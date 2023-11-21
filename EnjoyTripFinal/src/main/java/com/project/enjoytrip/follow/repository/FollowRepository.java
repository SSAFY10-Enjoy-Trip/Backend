package com.project.enjoytrip.follow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.enjoytrip.follow.entity.Follow;

public interface FollowRepository extends JpaRepository<Follow, Follow.PK>{
	Optional<Follow> findByUserIdFromAndUserIdTo(int userIdFrom, int userIdTo);
    List<Follow> findAll();

    int countByUserIdFrom(int memberId);
    int countByUserIdTo(int memberId);

    void deleteAllByUserIdFrom(int memberId);
    void deleteAllByUserIdTo(int memberId);
}
