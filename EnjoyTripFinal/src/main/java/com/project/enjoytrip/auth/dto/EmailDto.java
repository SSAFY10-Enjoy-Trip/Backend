package com.project.enjoytrip.auth.dto;

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
public class EmailDto {

	@NotBlank
	private String email;
	
	@NotBlank
	private String name;
	
	private String password;
	
	@Builder
	public EmailDto(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}
	
	public Member toEntity() {
		return Member.builder()
				.email(email)
				.name(name)
				.build();
	}
	
	public EmailDto toDto(Member member) {
		return EmailDto.builder()
				.email(member.getEmail())
				.name(member.getName())
				.build();
	}
}
