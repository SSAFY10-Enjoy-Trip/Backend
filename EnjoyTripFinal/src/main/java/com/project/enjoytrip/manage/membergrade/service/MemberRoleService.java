package com.project.enjoytrip.manage.membergrade.service;

import java.util.List;

import com.project.enjoytrip.manage.membergrade.dto.RoleResponseDto;

public interface MemberRoleService {
	// Manager 역할 위임(Supervisor 가능)
	public boolean managerRoleAssignment(String userEmail);
	// Manager 역할 해제(Supervisor 가능)
	public boolean managerRoleDisAssignment(String userEmail);
	// ManagerList 조회(Supervisor 가능)
	public List<RoleResponseDto> managerList();
	// UserList 조회(Manager/Supervisor 가능)
	public List<RoleResponseDto> userList();
}
