package com.project.enjoytrip.like.service;

import java.util.List;

import com.project.enjoytrip.like.entity.Like;

public interface LikeService {
	
	boolean addHeart(int boardId, int userId);

	boolean amIHeart(int boardId, int userId);

	int likeCount(int boardId, int memberId);

	List<Like> findByUserId(int memberId);

}
