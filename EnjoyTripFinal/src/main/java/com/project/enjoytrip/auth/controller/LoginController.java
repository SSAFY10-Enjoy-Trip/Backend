package com.project.enjoytrip.auth.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	//Autowired service
	
	// Login (Post)
	@PostMapping(value="/login")
	public Map<String, String> login(HttpSession session){
		Map<String, String> map = new HashMap<>();
		return map;
	}
	
	// Logout (Get)
}
