package com.project.enjoytrip.follow.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

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
public class Follow {
	@EmbeddedId // 복합키 적용
	private FollowId followId;
}
