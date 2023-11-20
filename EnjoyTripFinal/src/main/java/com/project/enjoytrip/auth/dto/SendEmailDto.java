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
public class SendEmailDto {

	@NotBlank
	private String address;
	
	private String title;
	private String message;
	
	@Builder
	public SendEmailDto(String address, String title, String message) {
		this.address = address;
		this.title = title;
		this.message = message;
	}
}
