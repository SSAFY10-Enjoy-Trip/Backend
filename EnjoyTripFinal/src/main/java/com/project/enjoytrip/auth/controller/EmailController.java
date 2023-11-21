package com.project.enjoytrip.auth.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.enjoytrip.auth.dto.EmailDto;
import com.project.enjoytrip.auth.dto.SendEmailDto;
import com.project.enjoytrip.auth.service.EmailServiceImpl;

@RestController
public class EmailController {
	private EmailServiceImpl emailServiceImpl;

	public EmailController(EmailServiceImpl emailServiceImpl) {
		this.emailServiceImpl = emailServiceImpl;
	}
	
	@GetMapping(value = "/check/{email}")
	public Map<String, String> registerEmailCheck(@PathVariable String email){
		Map<String, String> map = new HashMap<>();
		EmailDto emailDto = new EmailDto();
		emailDto.setEmail(email);
		boolean check = emailServiceImpl.registerEmailCheck(emailDto);
		// check가 true => 등록되지 않은 계정 => 회원 가입 가능
		if (check) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		return map;
	}

	// password find
	@PostMapping(value = "/check/findPassword")
	public Map<String, String> findPassword(EmailDto emailDto) {
		Map<String, String> map = new HashMap<>();
		boolean check = emailServiceImpl.userEmailCheck(emailDto);
		if (check) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		return map;
	}

	// send temporary email and change password via temporary email
	@PostMapping(value = "/check/sendEmail")
	public void sendEmail(EmailDto emailDto) {
		SendEmailDto sendEmailDto  = emailServiceImpl.createMailAndChangePassword(emailDto);
		emailServiceImpl.mailSend(sendEmailDto);
	}
}
