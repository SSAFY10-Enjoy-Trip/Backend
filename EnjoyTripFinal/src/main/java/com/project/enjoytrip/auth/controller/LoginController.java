package com.project.enjoytrip.auth.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.enjoytrip.auth.dto.LoginDto;
import com.project.enjoytrip.auth.service.LoginServiceImpl;

@RestController
public class LoginController {
	private LoginServiceImpl loginServiceImpl;
	
	public LoginController(LoginServiceImpl loginServiceImpl) {
		this.loginServiceImpl = loginServiceImpl;
	}
	
	
	// Login (Post)
	@PostMapping(value="/login")
	public Map<String, String> login(@RequestBody LoginDto loginDto, HttpSession session){
		Map<String, String> map = new HashMap<>();
		LoginDto user = loginServiceImpl.Login(loginDto);
		
		if(user != null) {
			session.setAttribute("user", user); // 서버 용도
			map.put("result", "SUCCESS");
		}else {
			map.put("result", "FAIL");
		}
		
		return map;
	}
	
	// Logout (Get)
	@GetMapping(value="/logout")
	public Map<String, String> logout(HttpSession session){
		Map<String, String> map = new HashMap<>();
		if(session != null) {
			session.invalidate();
			map.put("result", "SUCCESS");
		}else {
			map.put("result", "FAIL");
		}

		return map;
	}
}
