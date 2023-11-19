package com.project.enjoytrip.follow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.enjoytrip.follow.entity.Follow;
import com.project.enjoytrip.follow.entity.FollowId;

public interface FollowRepository extends JpaRepository<Follow, FollowId>{
	boolean existsByFollowId(FollowId followId);
}
