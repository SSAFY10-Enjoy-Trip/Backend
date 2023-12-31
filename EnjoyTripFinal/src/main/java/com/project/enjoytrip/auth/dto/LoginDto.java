package com.project.enjoytrip.auth.dto;

import javax.validation.constraints.NotBlank;

import com.project.enjoytrip.manage.membergrade.entity.MemberRole;
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
public class LoginDto {
	
	private int memberId;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String profileImageUrl;
	
	private MemberRole memberRole;
	
	@Builder
	public LoginDto(int memberId, String email, String name, String password, String profileImageUrl, MemberRole memberRole) {
		this.memberId = memberId;
		this.email = email;
		this.name = name;
		this.password = password;
		this.profileImageUrl = profileImageUrl;
		this.memberRole = memberRole;
	}
	
	public Member toEntity() {
		return Member.builder()
				.email(email)
				.password(password)
				.build();
	}
	
	public LoginDto toDto(Member member) {
		return LoginDto.builder()
				.memberId(member.getMemberId())
				.email(member.getEmail())
				.name(member.getName())
				.password(member.getPassword())
				.profileImageUrl(member.getProfileImageUrl())
				.memberRole(member.getMemberRole())
				.build();
	}
}
