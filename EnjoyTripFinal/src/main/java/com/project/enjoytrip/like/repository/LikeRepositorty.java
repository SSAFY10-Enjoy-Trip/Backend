package com.project.enjoytrip.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.enjoytrip.like.entity.Like;

public interface LikeRepositorty extends JpaRepository<Like, Integer> {
//
//	boolean existByBoardIdAndUserId(int boardId, int userId);
//
//	void deleteByBoardIdAndUserId(int boardId, int userId);

}
