package com.project.enjoytrip.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.project.enjoytrip.auth.dto.LoginDto;

// 클라이언트에 대한 응답을 성공/실패 <= json 문자열 "result":"login"
@Component
public class LoginInterceptor implements HandlerInterceptor {
	private final String jsonStr = "{\"result\":\"login\"}";
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("LoginInterceptor >>> " + request.getRequestURI());
		
		// JSP 없이 비동기 처리만!
		HttpSession session = request.getSession();
		LoginDto loginDto = (LoginDto) session.getAttribute("user");

		if(loginDto == null) {
			// 로그인이 필요하다는 응답
			response.getWriter().write(jsonStr);
			return false;
		}
		
		return true;
	}
}
