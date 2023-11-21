package com.project.enjoytrip.auth.service;

import com.project.enjoytrip.auth.dto.EmailDto;
import com.project.enjoytrip.auth.dto.SendEmailDto;

public interface EmailService {
	public boolean registerEmailCheck(EmailDto emailDto);
	public boolean userEmailCheck(EmailDto emailDto);
	public SendEmailDto createMailAndChangePassword(EmailDto emailDto);
	public void updatePassword(EmailDto emailDto);
	public String getTempPassword();
	public void mailSend(SendEmailDto sendEmailDto);
}
