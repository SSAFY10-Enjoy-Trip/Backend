package com.project.enjoytrip.bookmark.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.project.enjoytrip.board.entity.Board;
import com.project.enjoytrip.member.entity.Member;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
/*
 * @Embeddable 방식 선택 이유
 * 객체 지향적인 설계를 지향.
 * 복합키를 직접 조회할 필요가 없음.
 * 조회 성능이 저하될 가능성이 낮음.
 * */
public class BookmarkId implements Serializable {
	private static final long serialVersionUID = -4067764361996890460L;
    
//    private Member member; // Memeber 외래키

    @ManyToOne
    private Board board; // Board 외래키
}
