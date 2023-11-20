package com.project.enjoytrip.auth.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.project.enjoytrip.auth.dto.EmailDto;
import com.project.enjoytrip.auth.dto.SendEmailDto;
import com.project.enjoytrip.auth.repository.EmailRepository;
import com.project.enjoytrip.member.entity.Member;

@Service
public class EmailServiceImpl implements EmailService {
	private EmailRepository emailRepository;
	
	@Autowired
	private JavaMailSender mailSender;
	private static final String FROM_ADDRESS = "guddnr0421@naver.com";

	public EmailServiceImpl(EmailRepository emailRepository) {
		this.emailRepository = emailRepository;
	}

	// 해당 email로 가입된 정보가 있는지 확인 및 email과 name이 일치하는지 체크
	@Override
	@Transactional
	public boolean userEmailCheck(EmailDto emailDto) {
		Member member = emailRepository.findByEmail(emailDto.getEmail());

		if (member != null && member.getName().equals(emailDto.getName())) {
			return true;
		}

		return false;
	}

	@Override
	@Transactional
	public SendEmailDto createMailAndChangePassword(EmailDto emailDto) {
		String tempPassword = getTempPassword();
		SendEmailDto sendEmailDto = new SendEmailDto();
		sendEmailDto.setAddress(emailDto.getEmail());
		sendEmailDto.setTitle(emailDto.getName()+" 님의 임시 비밀번호 안내 이메일입니다.");
		sendEmailDto.setMessage(emailDto.getName()+" 님의 임시 비밀번호는 "+tempPassword+" 입니다.");
		
		emailDto.setPassword(tempPassword);
		updatePassword(emailDto);
		
		return sendEmailDto;
	}

	@Override
	@Transactional
	public void updatePassword(EmailDto emailDto) {
		Member member = emailRepository.findByEmail(emailDto.getEmail());
		member.setPassword(emailDto.getPassword());
	}

	@Override
	public String getTempPassword() {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
                'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

        String str = "";

        int idx = 0;
        for (int i = 0; i < 10; i++) {
            idx = (int) (charSet.length * Math.random());
            str += charSet[idx];
        }
        return str;
	}

	@Override
	@Async
	public void mailSend(SendEmailDto sendEmailDto) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(sendEmailDto.getAddress());
		message.setFrom(EmailServiceImpl.FROM_ADDRESS);
		message.setSubject(sendEmailDto.getTitle());
		message.setText(sendEmailDto.getMessage());
	
		mailSender.send(message);
	}
}
