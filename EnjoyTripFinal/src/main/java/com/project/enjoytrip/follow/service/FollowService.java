package com.project.enjoytrip.follow.service;

import java.util.List;

import com.project.enjoytrip.follow.dto.FollowRequestDto;
import com.project.enjoytrip.follow.dto.FollowResponseDto;

public interface FollowService {
	public Boolean addFollow(FollowRequestDto followRequestDto);
	public Boolean unFollow(FollowRequestDto followRequestDto);
	public List<FollowResponseDto> getAllFollowerMember(FollowRequestDto followRequestDto);
	public List<FollowResponseDto> getAllFollowingMember(FollowRequestDto followRequestDto);
	public Integer getFollowingCount(FollowRequestDto followRequestDto);
	public Integer getFollowerCount(FollowRequestDto followRequestDto);
//	public boolean isFollowingById(int userIdFrom, int userIdTo);
	public boolean isFollowingByUserEmail(FollowRequestDto followRequestDto);
}
