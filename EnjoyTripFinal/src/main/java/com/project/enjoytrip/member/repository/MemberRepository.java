package com.project.enjoytrip.member.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.enjoytrip.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	boolean existsByEmail(String email);
	Optional<Member> findByEmail(String email);
	
	@Query(value = "select * from follow f INNER JOIN member m ON f.user_id_to = m.member_id where f.user_id_from = :user_id", nativeQuery = true)
    List<Member> findAllByUserIdFrom(@Param("user_id") int userId);

    @Query(value = "select * from follow f INNER JOIN member m ON f.user_id_from = m.member_id where f.user_id_to = :user_id", nativeQuery = true)
    List<Member> findAllByUserIdTo(@Param("user_id") int userId);
}
