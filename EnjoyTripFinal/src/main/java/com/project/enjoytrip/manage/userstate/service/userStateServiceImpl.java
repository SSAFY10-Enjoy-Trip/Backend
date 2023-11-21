package com.project.enjoytrip.manage.userstate.service;

import org.springframework.stereotype.Service;

@Service
public class userStateServiceImpl {
	// 유저 상태 Enum으로 만들어서 관리한다.(DORMANT: 휴면 / SUSPENDED: 정지)
	// 휴면 상태 -> 최근 접속일자를 기준으로 매 번 로그인 할 때마다 현재 시간과 최근 접속일자를 체크
	// 정지 상태 -> manager 또는 supservisor가 expiration date를 설정하고 정지.

	// 로그인할 때 
	// 유저 상태 휴면 전환

	// 유저 상태 휴면 해제

	// 유저 상태 정지 전환

	// 유저 상태 정지 해제
}
