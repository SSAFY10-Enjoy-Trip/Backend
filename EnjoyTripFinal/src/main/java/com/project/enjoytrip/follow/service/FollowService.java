package com.project.enjoytrip.follow.service;

import com.project.enjoytrip.follow.dto.FollowDto;

public interface FollowService {
	public boolean Follow(FollowDto followDto);
	public boolean unFollow(FollowDto followDto);
	public boolean checkFollowDuplicate(FollowDto followDto);
}
