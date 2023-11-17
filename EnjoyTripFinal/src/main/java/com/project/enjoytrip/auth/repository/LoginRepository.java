package com.project.enjoytrip.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.enjoytrip.member.entity.Member;

public interface LoginRepository extends JpaRepository<Member, Long>{
	Member findByEmail(String email);
}
