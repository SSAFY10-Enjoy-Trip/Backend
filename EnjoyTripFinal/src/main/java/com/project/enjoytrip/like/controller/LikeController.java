package com.project.enjoytrip.like.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.enjoytrip.auth.dto.LoginDto;
import com.project.enjoytrip.like.service.LikeService;

@RestController
public class LikeController {

	private LikeService likeService;

	public LikeController(LikeService likeService) {
		this.likeService = likeService;
	}

	// 좋아요 등록하기
	/*
	 * Q. 데이터가 한 개인데 나는 왜 POST를 선택했는가.
	 * GET 요청은 브라우저에 Caching이 되기 때문에  
	 * POST 방식으로 요청할 것을 데이터 크기가 작고 보안의 문제가 없다는 이유로  
	 * GET 으로 요청할 경우 기존에 캐싱된 데이터가 응답될 가능성이 존재한다. 
	 * */
	@PostMapping(value = "/like")
	public Map<String, String> AddHeart(int boardId, HttpSession session) {
		Map<String, String> map = new HashMap<>();
		LoginDto loginDto  = (LoginDto) session.getAttribute("user");
		if (likeService.addHeart(boardId, loginDto.getMemberId())) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		return map;
	}

//	// 팔로우 취소하기
//	@DeleteMapping(value = "/follow")
//	public Map<String, String> unFollow(FollowDto followDto) {
//		Map<String, String> map = new HashMap<>();
//		if (followService.unFollow(followDto)) {
//			map.put("unFollow", "success");
//		} else {
//			map.put("unFollow", "fail");
//		}
//		return map;
//	}

}
