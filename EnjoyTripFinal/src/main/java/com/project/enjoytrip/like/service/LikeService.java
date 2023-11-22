package com.project.enjoytrip.like.service;

public interface LikeService {
	
	boolean addHeart(int boardId, int userId);

	boolean amIHeart(int boardId, int userId);

	int likeCount(int boardId, int memberId);

}
