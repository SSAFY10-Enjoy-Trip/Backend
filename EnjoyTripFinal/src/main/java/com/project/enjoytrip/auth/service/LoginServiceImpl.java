package com.project.enjoytrip.auth.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.enjoytrip.auth.dto.LoginDto;
import com.project.enjoytrip.auth.repository.LoginRepository;
import com.project.enjoytrip.member.entity.Member;

@Service
public class LoginServiceImpl implements LoginService{
	private LoginRepository loginRepository;

	public LoginServiceImpl(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	// 로그인
	@Override
	@Transactional
	public LoginDto Login(LoginDto loginDto) {
		Member member = loginRepository.findByEmail(loginDto.getEmail());
		if(member != null && member.getPassword().equals(loginDto.getPassword())) {
			return loginDto;
		}
		return null;
	}
}