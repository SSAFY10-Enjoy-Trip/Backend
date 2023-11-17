package com.project.enjoytrip.member.dto;

import javax.validation.constraints.NotBlank;

import com.project.enjoytrip.member.entity.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberModifyDto {
	@NotBlank
	private String email;
	
	@NotBlank
	private String password;
	
	@Builder
	public MemberModifyDto(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public Member toEntity() {
		return Member.builder()
				.email(email)
				.password(password)
				.build();
	}
	
	public MemberRegisterDto toDto(Member member) {
		return MemberRegisterDto.builder()
				.email(member.getEmail())
				.password(member.getPassword())
				.build();
	}
}
