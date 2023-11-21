package com.project.enjoytrip.follow.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.project.enjoytrip.member.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Embeddable
// Follow 테이블을 위한 복합키 클래스다.
public class FollowId implements Serializable {

	private static final long serialVersionUID = -5465226196014097884L;

	@JoinColumn(name = "user_id_from")
	private Member userFrom;
	
	@JoinColumn(name = "user_id_to")
	private Member userTo;
}
