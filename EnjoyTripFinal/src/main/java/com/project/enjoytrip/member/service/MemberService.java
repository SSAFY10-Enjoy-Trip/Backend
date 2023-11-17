package com.project.enjoytrip.member.service;

import com.project.enjoytrip.member.dto.MemberDeleteDto;
import com.project.enjoytrip.member.dto.MemberFindAllDto;
import com.project.enjoytrip.member.dto.MemberFindDto;
import com.project.enjoytrip.member.dto.MemberModifyDto;
import com.project.enjoytrip.member.dto.MemberRegisterDto;

public interface MemberService {

	public MemberFindDto Find(MemberFindDto memberFindDto);
	public MemberFindAllDto FindAll();
	public boolean Register(MemberRegisterDto memberRegisterDto);
	public boolean Modify(MemberModifyDto memberModifyDto);
	public boolean Delete(MemberDeleteDto memberDeleteDto);
	public boolean checkEmailDuplicate(String email);
}
