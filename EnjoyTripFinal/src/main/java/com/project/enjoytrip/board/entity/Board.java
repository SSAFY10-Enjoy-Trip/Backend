package com.project.enjoytrip.board.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import com.project.enjoytrip.member.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity  
@Data  
@Builder  
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Table(name="trip_board")
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="board_id")
	private int boardId;
	@Column(nullable = false, insertable = true, updatable = true)
	private String title;
	@Column(nullable = false, insertable = true, updatable = true, columnDefinition="TEXT")
	private String content;
	@Column(name="reg_dt", columnDefinition = "datetime default current_timestamp")
	private LocalDateTime regDt;
	@Column(name="read_count")
	private int readCount;
	@Column(name="like_count")
	private int likeCount;
	
	// member_id 외래키 지정
	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="user_id") // PK가 하나라 생략가능 하지만 명시함. referencedColumnName="member_id"
	private Member member;
	
	// Insert, Update
	public Board(Member member, String title, String content, LocalDateTime regDt) {
		this.title = title;
		this.content = content;
		this.regDt = regDt;
		this.member = member;
	}
	

}
