package com.project.enjoytrip.manage.membergrade.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.enjoytrip.exception.ExceptionCode;
import com.project.enjoytrip.exception.account.AccountException;
import com.project.enjoytrip.manage.membergrade.dto.RoleResponseDto;
import com.project.enjoytrip.manage.membergrade.entity.MemberRole;
import com.project.enjoytrip.manage.membergrade.entity.Role;
import com.project.enjoytrip.manage.membergrade.repository.MemberRoleRepository;
import com.project.enjoytrip.member.entity.Member;
import com.project.enjoytrip.member.repository.MemberRepository;

@Service
public class MemberRoleServiceImpl implements MemberRoleService {

	private MemberRoleRepository memberRoleRepository;
	private MemberRepository memberRepository;

	public MemberRoleServiceImpl(MemberRoleRepository memberRoleRepository, MemberRepository memberRepository) {
		this.memberRoleRepository = memberRoleRepository;
		this.memberRepository = memberRepository;
	}

	// Manager 역할 위임(Supervisor 가능)
	@Override
	@Transactional
	public boolean managerRoleAssignment(String tarGetUserEmail) {
		// 1. memberRepositories에서 userEmail로 Memeber 객체를 가져온다.
		Member member = memberRepository.findByEmail(tarGetUserEmail)
				.orElseThrow(() -> new AccountException(ExceptionCode.NOT_FOUND_ACCOUNT));

		// 2. 가져온 Member 객체를 이용하여 MemberRole 테이블에서 해당 역할을 조회한다.
		MemberRole memberRole = memberRoleRepository.findById(member.getMemberRole().getRoleId())
				.orElseThrow(() -> new IllegalArgumentException("No Such Member Role"));

		// 3. 조회한 유저의 역할이 있으면 ROLE_MANAGER로 바꾸고 return true;
		if (memberRole != null) {
			memberRole.setRole(Role.ROLE_MANAGER);
			return true;
		}
		// 4. 바꾸는데 실패했으면 return false;
		return false;
	}

	// Manager 역할 해제(Supervisor 가능)
	@Override
	@Transactional
	public boolean managerRoleDisAssignment(String tarGetUserEmail) {
		// 1. memberRepositories에서 tarGetUserEmail로 Memeber 객체를 가져온다.
		Member member = memberRepository.findByEmail(tarGetUserEmail)
				.orElseThrow(() -> new AccountException(ExceptionCode.NOT_FOUND_ACCOUNT));

		// 2. 가져온 Member 객체를 이용하여 MemberRole 테이블에서 해당 역할을 조회한다.
		MemberRole memberRole = memberRoleRepository.findById(member.getMemberRole().getRoleId())
				.orElseThrow(() -> new IllegalArgumentException("No Such Member Role"));

		// 3. 조회한 유저의 역할이 있으면 ROLE_MANAGER로 바꾸고 return true;
		if (memberRole != null) {
			memberRole.setRole(Role.ROLE_USER);
			return true;
		}
		// 4. 바꾸는데 실패했으면 return false;
		return false;
	}

	// ManagerList 조회(Supervisor 가능)
	@Override
	public List<RoleResponseDto> managerList() {
		List<MemberRole> list = memberRoleRepository.findByMemberRole("ROLE_MANAGER");
		List<RoleResponseDto> managerList = new ArrayList<>();

		for (MemberRole role : list) {
			RoleResponseDto roleResponseDto = new RoleResponseDto();
			roleResponseDto.setEmail(role.getMember().getEmail());
			roleResponseDto.setName(role.getMember().getName());
			roleResponseDto.setProfileImageUrl(role.getMember().getProfileImageUrl());
			roleResponseDto.setRole(role.getRole());
			managerList.add(roleResponseDto);
		}
		return managerList;
	}

	// UserList 조회(Manager/Supervisor 가능)
	@Override
	public List<RoleResponseDto> userList() {
		List<MemberRole> list = memberRoleRepository.findByMemberRole("ROLE_USER");
		List<RoleResponseDto> userList = new ArrayList<>();
		
		for (MemberRole role : list) {
			RoleResponseDto roleResponseDto = new RoleResponseDto();
			roleResponseDto.setEmail(role.getMember().getEmail());
			roleResponseDto.setName(role.getMember().getName());
			roleResponseDto.setProfileImageUrl(role.getMember().getProfileImageUrl());
			roleResponseDto.setRole(role.getRole());
			userList.add(roleResponseDto);
		}
		return userList;
	}
}
