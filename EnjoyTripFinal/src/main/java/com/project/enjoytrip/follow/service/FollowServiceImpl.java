package com.project.enjoytrip.follow.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.enjoytrip.follow.dto.FollowDto;
import com.project.enjoytrip.follow.entity.Follow;
import com.project.enjoytrip.follow.entity.FollowId;
import com.project.enjoytrip.follow.repository.FollowRepository;

@Service
public class FollowServiceImpl implements FollowService {

	private FollowRepository followRepository;

	public FollowServiceImpl(FollowRepository followRepository) {
		this.followRepository = followRepository;
	}

	@Override
	@Transactional
	public boolean Follow(FollowDto followDto) {

		// 팔로우 중복 체크
		if (!checkFollowDuplicate(followDto)) {
			try {
				followRepository.save(new Follow(followDto.toEntity()));
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Following Service" + e.getMessage());
			}
		}

		return false;
	}

	@Override
	@Transactional
	public boolean unFollow(FollowDto followDto) {
		try {
			followRepository.delete(new Follow(followDto.toEntity()));
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("unFollow Service" + e.getMessage());
		}
		return false;
	}

	@Override
	@Transactional
	public boolean checkFollowDuplicate(FollowDto followDto) {
		return followRepository.existsByFollowId(followDto.toEntity());
	}

}
