package com.project.enjoytrip.follow.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.enjoytrip.exception.ExceptionCode;
import com.project.enjoytrip.exception.account.AccountException;
import com.project.enjoytrip.exception.follow.FollowException;
import com.project.enjoytrip.exception.global.NotFoundException;
import com.project.enjoytrip.follow.dto.FollowRequestDto;
import com.project.enjoytrip.follow.dto.FollowResponseDto;
import com.project.enjoytrip.follow.entity.Follow;
import com.project.enjoytrip.follow.entity.FollowStatus;
import com.project.enjoytrip.follow.repository.FollowRepository;
import com.project.enjoytrip.member.entity.Member;
import com.project.enjoytrip.member.repository.MemberRepository;

@Service
public class FollowServiceImpl implements FollowService {

	private FollowRepository followRepository;
	private MemberRepository memberRepository;
	
	public FollowServiceImpl(FollowRepository followRepository, MemberRepository memberRepository) {
		this.followRepository = followRepository;
		this.memberRepository = memberRepository;
	}

	@Transactional
	public Boolean addFollow(FollowRequestDto followRequestDto){
        if(Objects.equals(followRequestDto.getUserEmailFrom(), followRequestDto.getUserEmailTo())) {
            throw new FollowException(ExceptionCode.SAME_ACCOUNT);
        }

        Member userFrom = memberRepository.findByEmail(followRequestDto.getUserEmailFrom())
                .orElseThrow(() -> new AccountException(ExceptionCode.NOT_FOUND_ACCOUNT));
        
        Member userTo = memberRepository.findByEmail(followRequestDto.getUserEmailTo())
                .orElseThrow(() -> new AccountException(ExceptionCode.NOT_FOUND_ACCOUNT));

        Optional<Follow> relation = getFollowRelation(userFrom.getMemberId(), userTo.getMemberId());
        if(relation.isPresent()) {
            throw new FollowException(ExceptionCode.ALREADY_EXIST_FOLLOW);
        }
        followRepository.save(new Follow(userFrom.getMemberId(), userTo.getMemberId()));
        return true;
    }

	@Transactional
    public Boolean unFollow(FollowRequestDto followRequestDto) {
        if(Objects.equals(followRequestDto.getUserEmailFrom(), followRequestDto.getUserEmailTo())) {
            throw new FollowException(ExceptionCode.SAME_ACCOUNT);
        }

        Member userTo = memberRepository.findByEmail(followRequestDto.getUserEmailTo())
                .orElseThrow(() -> new AccountException(ExceptionCode.NOT_FOUND_ACCOUNT));

        Member userFrom = memberRepository.findByEmail(followRequestDto.getUserEmailFrom())
                .orElseThrow(() -> new AccountException(ExceptionCode.NOT_FOUND_ACCOUNT));

        Optional<Follow> relation = getFollowRelation(userFrom.getMemberId(), userTo.getMemberId());
        if(!relation.isPresent()) {
            throw new NotFoundException(ExceptionCode.NOT_FOUND_FOLLOW);
        }
        followRepository.delete(relation.get());
        return true;
    }

    private Optional<Follow> getFollowRelation(int userIdFrom, int userIdTo) {
        return followRepository.findByUserIdFromAndUserIdTo(userIdFrom, userIdTo);
    }

    @Transactional
    public List<FollowResponseDto> getAllFollowerMember(FollowRequestDto followRequestDto) {
    	Member member = memberRepository.findByEmail(followRequestDto.getUserEmailFrom())
                .orElseThrow(() -> new AccountException(ExceptionCode.NOT_FOUND_ACCOUNT));

    	Member requestingUser;
        if(followRequestDto.getUserEmailFrom().equals(followRequestDto.getUserEmailTo())) {
            requestingUser = member;
        }
        else {
            requestingUser = memberRepository.findByEmail(followRequestDto.getUserEmailTo())
                    .orElseThrow(() -> new AccountException(ExceptionCode.NOT_FOUND_ACCOUNT));
        }

        List<FollowResponseDto> members = getAllByToUser(member.getMemberId());
        if(followRequestDto.getUserEmailFrom().equals(followRequestDto.getUserEmailTo())) {
        	for(FollowResponseDto userInfo : members) {
                userInfo.setRequestingUserEmail(followRequestDto.getUserEmailFrom());
                userInfo.setFollowStatus(FollowStatus.FOLLOWING);
            }
        }
        else {
            Set<String> usernameFollowedByRequestingUser = getAllUsernameFollowedByUser(requestingUser.getMemberId());
            for(FollowResponseDto userInfo : members) {
                userInfo.setRequestingUserEmail(followRequestDto.getUserEmailTo());
                setFollowStatus(userInfo.getUserEmail(), requestingUser.getEmail(), usernameFollowedByRequestingUser, userInfo);
            }
        }
        return members;
    }

    @Transactional
    public List<FollowResponseDto> getAllFollowingMember(FollowRequestDto followRequestDto) {
    	Member member = memberRepository.findByEmail(followRequestDto.getUserEmailFrom())
                .orElseThrow(() -> new AccountException(ExceptionCode.NOT_FOUND_ACCOUNT));

    	Member requestingUser;
        if(followRequestDto.getUserEmailTo().equals(followRequestDto.getUserEmailFrom())) {
            requestingUser = member;
        }
        else {
            requestingUser = memberRepository.findByEmail(followRequestDto.getUserEmailTo())
                    .orElseThrow(() -> new AccountException(ExceptionCode.NOT_FOUND_ACCOUNT));
        }

        List<FollowResponseDto> members = getAllByFromUser(member.getMemberId());
        if(followRequestDto.getUserEmailFrom().equals(followRequestDto.getUserEmailTo())) {
            for(FollowResponseDto userInfo : members) {
                userInfo.setRequestingUserEmail(followRequestDto.getUserEmailFrom());
                userInfo.setFollowStatus(FollowStatus.FOLLOWING);
            }
        }
        else {
            Set<String> usernameFollowedByRequestingUser = getAllUsernameFollowedByUser(requestingUser.getMemberId());
            for(FollowResponseDto userInfo : members) {
                userInfo.setRequestingUserEmail(followRequestDto.getUserEmailTo());
                setFollowStatus(userInfo.getUserEmail(), followRequestDto.getUserEmailTo(), usernameFollowedByRequestingUser, userInfo);
            }
        }
        return members;
    }

    @Transactional
    public Integer getFollowingCount(String userEmail){
    	Member member = memberRepository.findByEmail(userEmail)
                .orElseThrow(() -> new AccountException(ExceptionCode.NOT_FOUND_ACCOUNT));

        return followRepository.countByUserIdFrom(member.getMemberId());
    }

    @Transactional
    public Integer getFollowerCount(String userEmail){
    	Member member = memberRepository.findByEmail(userEmail)
                .orElseThrow(() -> new AccountException(ExceptionCode.NOT_FOUND_ACCOUNT));

        return followRepository.countByUserIdTo(member.getMemberId());
    }

    @Transactional
    public void deleteFollowRelation(int userId){
        followRepository.deleteAllByUserIdFrom(userId);
        followRepository.deleteAllByUserIdTo(userId);
    }

    @Transactional
    public boolean isFollowingById(int userIdFrom, int userIdTo) {
        return followRepository.findByUserIdFromAndUserIdTo(userIdFrom, userIdTo).isPresent();
    }

    @Transactional
    public boolean isFollowingByUserEmail(FollowRequestDto followRequestDto) {
    	Member userFrom = memberRepository.findByEmail(followRequestDto.getUserEmailFrom())
                .orElseThrow(() -> new AccountException(ExceptionCode.NOT_FOUND_ACCOUNT));
    	
    	Member userTo = memberRepository.findByEmail(followRequestDto.getUserEmailTo())
                .orElseThrow(() -> new AccountException(ExceptionCode.NOT_FOUND_ACCOUNT));

        return isFollowingById(userFrom.getMemberId(), userTo.getMemberId());
    }

    @Transactional
    public void setFollowStatus(String targetUserEmail, String requestingUserEmail, Set<String> usernameFollowedByRequestingUser, FollowResponseDto userInfo) {
        if(requestingUserEmail.equals(targetUserEmail)) {
            userInfo.setFollowStatus(FollowStatus.ONESELF);
        }
        else if(usernameFollowedByRequestingUser.contains(targetUserEmail)) {
            userInfo.setFollowStatus(FollowStatus.FOLLOWING);
        }
        else {
        	System.out.println("여기여기여기여기"+targetUserEmail+" / " + requestingUserEmail);
            userInfo.setFollowStatus(FollowStatus.UNFOLLOW);
        }
    }

    @Transactional
    public Set<String> getAllUsernameFollowedByUser(int userId) {
        List<Member> members = memberRepository.findAllByUserIdFrom(userId);
        Set<String> userEmailSet = new HashSet<>();
        for(Member member : members) {
        	userEmailSet.add(member.getEmail());
        }
        return userEmailSet;
    }

    @Transactional
    public List<FollowResponseDto> getAllByToUser(int userId) {
        List<Member> members = memberRepository.findAllByUserIdTo(userId);
        List<FollowResponseDto> followerList = new ArrayList<>();
        for(Member member : members) {
        	FollowResponseDto followResponseDto = new FollowResponseDto();
        	followResponseDto.setUserEmail(member.getEmail());
        	followResponseDto.setName(member.getName());
        	followerList.add(followResponseDto);
        }
        return followerList;
    }

    @Transactional
    public List<FollowResponseDto> getAllByFromUser(Integer userId) {
        List<Member> members = memberRepository.findAllByUserIdFrom(userId);
        List<FollowResponseDto> followingList = new ArrayList<>();
        for(Member member : members) {
        	FollowResponseDto followResponseDto = new FollowResponseDto();
        	followResponseDto.setUserEmail(member.getEmail());
        	followResponseDto.setName(member.getName());
            followingList.add(followResponseDto);
        }
        return followingList;
    }

}
