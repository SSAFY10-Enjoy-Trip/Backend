package com.project.enjoytrip.member.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberFindAllDto {
	private List<MemberFindByEmailDto> memberList;
}
