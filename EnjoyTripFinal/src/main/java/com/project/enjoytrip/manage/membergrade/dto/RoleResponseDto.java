package com.project.enjoytrip.manage.membergrade.dto;

import com.project.enjoytrip.manage.membergrade.entity.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class RoleResponseDto {
	private String email;
	private String name;
	private String profileImageUrl;
	private Role role;
}
