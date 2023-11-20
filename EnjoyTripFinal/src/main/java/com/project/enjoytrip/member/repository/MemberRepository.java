package com.project.enjoytrip.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.enjoytrip.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	boolean existsByEmail(String email);
	Member findByEmail(String email);
}
