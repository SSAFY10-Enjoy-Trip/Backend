package com.project.enjoytrip.manage.membergrade.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.enjoytrip.manage.membergrade.dto.RoleRequestDto;
import com.project.enjoytrip.manage.membergrade.dto.RoleResponseDto;
import com.project.enjoytrip.manage.membergrade.entity.Role;
import com.project.enjoytrip.manage.membergrade.service.MemberRoleServiceImpl;

@RestController
@RequestMapping(value="/role")
public class MemberRoleController {
	private MemberRoleServiceImpl memberRoleServiceImpl;
	
	public MemberRoleController(MemberRoleServiceImpl memberRoleServiceImpl) {
		this.memberRoleServiceImpl = memberRoleServiceImpl;
	}
	
	// =============== SuperVisor ===============
	// Manager 역할 위임(Supervisor만 가능)
	@PutMapping(value="/assignment")
	public Map<String, String> managerRoleAssignment(RoleRequestDto roleRequestDto) {
		Map<String, String> map = new HashMap<>();
		boolean result = false;
		if(roleRequestDto.getRole() == Role.ROLE_SUPERVISOR) {
			result = memberRoleServiceImpl.managerRoleAssignment(roleRequestDto.getEmail());
		}
		
		if(result) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		
		return map;
	}

	// Manager 역할 해제(Supervisor만 가능)
	@PutMapping(value="/disAssignment")
	public Map<String, String> managerRoleDisAssignment(RoleRequestDto roleRequestDto) {
		Map<String, String> map = new HashMap<>();
		boolean result = false;
		if(roleRequestDto.getRole() == Role.ROLE_SUPERVISOR) {
			result = memberRoleServiceImpl.managerRoleDisAssignment(roleRequestDto.getEmail());
		}
		
		if(result) {
			map.put("result", "success");
		}else {
			map.put("result", "fail");
		}
		
		return map;
	}

	// ManagerList 조회(Supervisor 가능)
	@PostMapping(value="/managerList")
	public Map<String, List<RoleResponseDto>> managerList(RoleRequestDto roleRequestDto) {
		Map<String, List<RoleResponseDto>> map = new HashMap<>();
		List<RoleResponseDto> managerList = null;
		if(roleRequestDto.getRole() == Role.ROLE_SUPERVISOR) {
			managerList = memberRoleServiceImpl.managerList();
		}
		
		// managerList를 서비스 레이어에서 정상적으로 가져왔으면 값이 들어있고 아니면 null
		map.put("result", managerList);
		
		return map;
	}

	
	// ========== Manager or SuperVisor ==========
	// UserList 조회(Manager/Supervisor 가능)
	@PostMapping(value="/userList")
	public Map<String, List<RoleResponseDto>> userList(RoleRequestDto roleRequestDto) {
		Map<String, List<RoleResponseDto>> map = new HashMap<>();
		List<RoleResponseDto> managerList = null;
		if(roleRequestDto.getRole() == Role.ROLE_SUPERVISOR) {
			managerList = memberRoleServiceImpl.userList();
		}
		
		// managerList를 서비스 레이어에서 정상적으로 가져왔으면 값이 들어있고 아니면 null
		map.put("result", managerList);
		
		return map;
	}
}
