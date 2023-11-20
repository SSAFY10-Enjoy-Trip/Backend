package com.project.enjoytrip.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.enjoytrip.member.dto.MemberDeleteDto;
import com.project.enjoytrip.member.dto.MemberFindAllDto;
import com.project.enjoytrip.member.dto.MemberFindByEmailDto;
import com.project.enjoytrip.member.dto.MemberModifyDto;
import com.project.enjoytrip.member.dto.MemberRegisterDto;
import com.project.enjoytrip.member.service.MemberServiceImpl;

@RestController
public class MemberController {

	private MemberServiceImpl memberServiceImpl;
	
	MemberController(MemberServiceImpl memberServiceImpl){
		this.memberServiceImpl = memberServiceImpl;
	}
	
	// 회원 가입
	@PostMapping("/member")
	public Map<String, String> register(@RequestBody MemberRegisterDto memberRegisterDto){
		System.out.println("/register");
		
		Map<String, String> map = new HashMap<>();
		if(memberServiceImpl.Register(memberRegisterDto)) {
			map.put("register", "success");
		}else {
			map.put("register", "fail");
		}
		return map;
	}
	
	// 회원 1건 조회
	@GetMapping("/member")
	public MemberFindByEmailDto find(MemberFindByEmailDto memberFindByEmailDto){
		System.out.println("/find");
		
		return memberServiceImpl.FindByEmail(memberFindByEmailDto);

	}
	
	// 회원 전체 조회
	@GetMapping("/member/list")
	public MemberFindAllDto findAll(){
		System.out.println("/findAll");
		
		return memberServiceImpl.FindAll();

	}
	
	// 회원 수정
	@PutMapping("/member")
	public Map<String, String> Modify(@RequestBody MemberModifyDto memberModifyDto){
		System.out.println("/register");
		
		Map<String, String> map = new HashMap<>();
		if(memberServiceImpl.Modify(memberModifyDto)) {
			map.put("register", "success");
		}else {
			map.put("register", "fail");
		}
		return map;
	}
	
	// 회원 삭제
	@DeleteMapping("/member")
	public Map<String, String> Delete(@RequestBody MemberDeleteDto memberDeleteDto){
		System.out.println("/delete");
		
		Map<String, String> map = new HashMap<>();
		if(memberServiceImpl.Delete(memberDeleteDto)) {
			map.put("register", "success");
		}else {
			map.put("register", "fail");
		}
		return map;
	}
	
}
