package com.project.enjoytrip.follow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.enjoytrip.follow.entity.Follow;
import com.project.enjoytrip.member.entity.Member;

public interface FollowRepository{
//public interface FollowRepository extends JpaRepository<Follow, Follow.PK>{
//	Optional<Follow> findByUserIdToAndUserIdFrom(Integer userIdFrom, Integer userIdTo);
//    List<Follow> findAll();
//
//    Integer countByUserIdFrom(Integer memberId);
//    Integer countByUserIdTo(Integer memberId);
//
//    @Query(value = "select m from follow f INNER JOIN member m ON f.user_id_to = m.member_id where f.user_id_from = :member_id")
//    List<Member> findAllByUserIdFrom(@Param("member_id") Integer memberId);
//
//    @Query(value = "select m from follow f INNER JOIN member m ON f.user_id_from = m.member_id where f.user_id_to = :member_id")
//    List<Member> findAllByUserIdTo(@Param("member_id") Integer memberId);
//
//    void deleteAllByUserIdFrom(Integer memberId);
//    void deleteAllByUserIdTo(Integer memberId);
}
