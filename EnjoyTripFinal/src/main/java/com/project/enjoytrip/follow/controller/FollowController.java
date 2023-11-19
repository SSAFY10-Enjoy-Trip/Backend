package com.project.enjoytrip.follow.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.enjoytrip.follow.dto.FollowDto;
import com.project.enjoytrip.follow.service.FollowService;

@RestController
public class FollowController {

	private FollowService followService;

	public FollowController(FollowService followService) {
		this.followService = followService;
	}

	// 팔로우 등록하기
	@PostMapping(value = "/follow")
	public Map<String, String> Follow(FollowDto followDto) {
		Map<String, String> map = new HashMap<>();
		if (followService.Follow(followDto)) {
			map.put("Follow", "SUCCESS");
		} else {
			map.put("Follow", "FAIL");
		}
		return map;
	}

	// 팔로우 취소하기
	@DeleteMapping(value = "/follow")
	public Map<String, String> unFollow(FollowDto followDto) {
		Map<String, String> map = new HashMap<>();
		if (followService.unFollow(followDto)) {
			map.put("unFollow", "SUCCESS");
		} else {
			map.put("unFollow", "FAIL");
		}
		return map;
	}

	// 나를 팔로우 하는 사람들 리스트
	@PostMapping(value = "/follow/followerList")
	public Map<String, String> followerList(FollowDto followDto) {
		Map<String, String> map = new HashMap<>();
		if (followService.unFollow(followDto)) {
			map.put("unFollow", "SUCCESS");
		} else {
			map.put("unFollow", "FAIL");
		}
		return map;
	}

	// 내가 팔로우 하는 사람들 리스트
	@PostMapping(value = "/follow/followingList")
	public Map<String, String> followingList(FollowDto followDto) {
		Map<String, String> map = new HashMap<>();
		if (followService.unFollow(followDto)) {
			map.put("unFollow", "SUCCESS");
		} else {
			map.put("unFollow", "FAIL");
		}
		return map;
	}

}
