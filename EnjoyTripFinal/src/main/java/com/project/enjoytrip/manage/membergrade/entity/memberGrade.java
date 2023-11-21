package com.project.enjoytrip.manage.membergrade.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.project.enjoytrip.member.entity.Member;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class memberGrade {
	private Member member;
	
	@Enumerated(EnumType.STRING)
	private Grade grade;
}