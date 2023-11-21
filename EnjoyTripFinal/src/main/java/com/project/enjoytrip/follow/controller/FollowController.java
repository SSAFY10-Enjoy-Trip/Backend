package com.project.enjoytrip.follow.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.enjoytrip.follow.dto.FollowRequestDto;
import com.project.enjoytrip.follow.dto.FollowResponseDto;
import com.project.enjoytrip.follow.service.FollowServiceImpl;

@RestController
@RequestMapping(value = "/follow")
public class FollowController {

	private FollowServiceImpl followServiceImpl;

	public FollowController(FollowServiceImpl followServiceImpl) {
		this.followServiceImpl = followServiceImpl;
	}

	// 팔로우 등록하기
	@PostMapping(value = "/follow")
	public Map<String, String> Follow(FollowRequestDto followRequestDto) {
		Map<String, String> map = new HashMap<>();
		if (followServiceImpl.addFollow(followRequestDto)) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		return map;
	}

	// 팔로우 취소하기
	@DeleteMapping(value = "/unfollow")
	public Map<String, String> unFollow(FollowRequestDto followRequestDto) {
		Map<String, String> map = new HashMap<>();
		if (followServiceImpl.unFollow(followRequestDto)) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		return map;
	}

	// 내가(from) 이 사람을(to)를 팔로우 하고 있는지 여부
	// 값을 반대로 넣어주면 이 사람이 나를 팔로우 하고 있는 지 알 수 있다.
	@GetMapping(value = "/following/{userEmailFrom}/{userEmailTo}")
	public Map<String, String> isFollowing(@PathVariable String userEmailFrom, @PathVariable String userEmailTo) {
		Map<String, String> map = new HashMap<>();
		FollowRequestDto followRequestDto = new FollowRequestDto(userEmailFrom, userEmailTo);
		if (followServiceImpl.isFollowingByUserEmail(followRequestDto)) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		return map;
	}

	// 나를 팔로우 하는 사람들 리스트
	@GetMapping(value = "/followerList/{userEmail}")
	public Map<String, List<FollowResponseDto>> followerList(@PathVariable String userEmail) {
		Map<String, List<FollowResponseDto>> map = new HashMap<>();
		FollowRequestDto followRequestDto = new FollowRequestDto(userEmail, userEmail);
		List<FollowResponseDto> followers = followServiceImpl.getAllFollowerMember(followRequestDto);
		map.put("result", followers);

		return map;
	}

	// 내가 팔로우 하는 사람들 리스트
	@GetMapping(value = "/followingList/{userEmail}")
	public Map<String, List<FollowResponseDto>> followingList(@PathVariable String userEmail) {
		Map<String, List<FollowResponseDto>> map = new HashMap<>();
		FollowRequestDto followRequestDto = new FollowRequestDto(userEmail, userEmail);
		List<FollowResponseDto> followings = followServiceImpl.getAllFollowingMember(followRequestDto);
		map.put("result", followings);
		return map;
	}

	// 나를 팔로우 하는 사람들 수
	@GetMapping(value = "/followers/{userEmail}")
	public Map<String, Integer> followers(@PathVariable String userEmail) {
		Map<String, Integer> map = new HashMap<>();
		int count = followServiceImpl.getFollowerCount(userEmail);
		map.put("result", count);

		return map;
	}

	// 내가 팔로잉 하는 사람들 수
	@GetMapping(value = "/followings/{userEmail}")
	public Map<String, Integer> followings(@PathVariable String userEmail) {
		Map<String, Integer> map = new HashMap<>();
		int count = followServiceImpl.getFollowingCount(userEmail);
		map.put("result", count);

		return map;
	}

}
