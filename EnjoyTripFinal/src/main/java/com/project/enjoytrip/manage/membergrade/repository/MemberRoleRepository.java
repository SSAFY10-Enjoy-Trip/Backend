package com.project.enjoytrip.manage.membergrade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.enjoytrip.manage.membergrade.entity.MemberRole;

public interface MemberRoleRepository extends JpaRepository<MemberRole, Integer>{
	
	@Query(value = "select * from member_role where role = :user_role", nativeQuery = true)
    List<MemberRole> findByMemberRole(@Param("user_role") String userRole);
}
