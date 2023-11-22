package com.project.enjoytrip.member.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicInsert;

import com.project.enjoytrip.manage.membergrade.entity.MemberRole;

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

// 25번 라인의 DynamicInsert 어노테이션은 null값인 경우 insert문에 반영하지 않는다. => profileImageUrl에 대해 DB의 Default값을 적용시키기 위해 사용.
// DB 쪽 테이블과 일치 시키기 위해 Column(nullable = false ~) 어노테이션 적용
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memberId;
	
	@Column(nullable = false, length = 45)
	private String email;
	
	@Column(nullable = false, length = 20)
	private String name;
	
	@Column(nullable = false, length = 20)
	private String password;
	
	@Column(nullable = false, length = 45)
	private String profileImageUrl;
	
	@OneToOne(mappedBy = "member")
	private MemberRole memberRole;
}
