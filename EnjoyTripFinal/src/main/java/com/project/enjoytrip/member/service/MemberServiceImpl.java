package com.project.enjoytrip.member.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.enjoytrip.member.dto.MemberDeleteDto;
import com.project.enjoytrip.member.dto.MemberFindAllDto;
import com.project.enjoytrip.member.dto.MemberFindByEmailDto;
import com.project.enjoytrip.member.dto.MemberFindByIdDto;
import com.project.enjoytrip.member.dto.MemberModifyDto;
import com.project.enjoytrip.member.dto.MemberRegisterDto;
import com.project.enjoytrip.member.entity.Member;
import com.project.enjoytrip.member.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {
	private MemberRepository memberRepository;

	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	// 회원가입
	@Override
	@Transactional
	public boolean Register(MemberRegisterDto memberRegisterDto) {
		// 회원 이메일 중복 체크(중복되면 회원 존재)
		if (!checkEmailDuplicate(memberRegisterDto.getEmail())) {
			try {
				// 회원이 존재하지 않으면 회원가입 후 return true
				memberRepository.save(memberRegisterDto.toEntity());
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Member Register Service" + e.getMessage());
			}
		}

		// 회원이 존재하면 return false;
		return false;
	}

	// 회원 1건 이메일로 조회
	@Override
	@Transactional
	public MemberFindByEmailDto FindByEmail(MemberFindByEmailDto memberFindByEmailDto) {
		return memberFindByEmailDto.toDto(memberRepository.findByEmail(memberFindByEmailDto.getEmail()).orElseThrow(() -> new IllegalArgumentException("no such data")));
	}
	
	// 회원 1건 Id로 조회
	@Override
	public MemberFindByIdDto FindById(MemberFindByIdDto memberFindByIdDto) {
		Member member = memberRepository.findById(memberFindByIdDto.getMemberId())
				.orElseThrow(() -> new IllegalArgumentException("no such data"));
		
		return memberFindByIdDto.toDto(member);
	}

	// 회원 전체 조회
	@Transactional
	public MemberFindAllDto FindAll() {
		List<Member> memberList = memberRepository.findAll();

		MemberFindAllDto memberFindAllDto = new MemberFindAllDto();
		memberFindAllDto.setMemberList(new ArrayList<>());
		for(Member member:memberList) {
			MemberFindByEmailDto memberFindDto = new MemberFindByEmailDto();
			memberFindAllDto.getMemberList().add(memberFindDto.toDto(member));
		}
		return memberFindAllDto;
	}

	// 회원 수정
	@Override
	@Transactional
	public boolean Modify(MemberModifyDto memberModifyDto) {
		Member member = memberRepository.findByEmail(memberModifyDto.getEmail()).orElseThrow(() -> new IllegalArgumentException("no such data"));
		if (member == null) {
			return false;
		}
		member.setPassword(memberModifyDto.getPassword());
		return true;
	}

	// 회원 삭제
	@Override
	@Transactional
	public boolean Delete(MemberDeleteDto memberDeleteDto) {
		Member member = memberRepository.findByEmail(memberDeleteDto.getEmail()).orElseThrow(() -> new IllegalArgumentException("no such data"));
		if (memberDeleteDto.getPassword().equals(member.getPassword())) {
			memberRepository.delete(member);
			return true;
		}
		return false;

	}

	// 회원 이메일 중복 여부 체크
	@Override
	@Transactional
	public boolean checkEmailDuplicate(String email) {
		return memberRepository.existsByEmail(email);
	}

}
