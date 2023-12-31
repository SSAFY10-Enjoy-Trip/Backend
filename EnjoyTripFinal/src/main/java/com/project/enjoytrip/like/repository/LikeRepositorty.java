package com.project.enjoytrip.like.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.enjoytrip.like.entity.Like;

public interface LikeRepositorty extends JpaRepository<Like, Integer> {

	boolean existsByBoardIdAndUserId(int boardId, int userId);

	void deleteByBoardIdAndUserId(int boardId, int userId);

	int countByBoardIdAndUserId(int boardId, int memberId);

	int countByBoardId(int boardId);

	List<Like> findByUserId(int memberId);

}
