package com.project.enjoytrip.auth.controller;

import java.util.HashMap;
import java.util.Map;

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
