package com.project.enjoytrip.like.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
/*
 * @Embeddable 방식 선택 이유
 * 객체 지향적인 설계를 지향.
 * 복합키를 직접 조회할 필요가 없음.
 * 조회 성능이 저하될 가능성이 낮음.
 * */
@Getter
@Table(name = "board_like")
public class Like implements Serializable {
	private static final long serialVersionUID = -4067764361996890460L;
    @Id
    private int likeId;

	@Column(nullable = false)
    private int userId;
	@Column(nullable = false)
    private int boardId;
    
    public Like(int boardId, int userId) {
    	this.boardId = boardId;
    	this.userId = userId;
    }
}
