package com.project.enjoytrip.manage.membergrade.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import com.project.enjoytrip.member.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DynamicInsert
@Table(name = "member_role")
public class MemberRole{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="role_id")
	private int roleId;
	
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name = "member_id")
	private Member member;

	@Enumerated(EnumType.STRING)
	@Column(name="role", nullable = false, length = 15)
	private Role role;
}