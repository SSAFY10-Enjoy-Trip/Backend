package com.project.enjoytrip.board.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import com.project.enjoytrip.board.entity.Board;
import com.project.enjoytrip.member.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardFindAllDetialDto {
	@NotBlank
	private int boardId;
	@NotBlank
	private String title;
	@NotBlank
	private String content;
	@NotBlank
	private String location;
	@NotBlank
	private String regDt;
	@NotBlank
	private int readCount;
	@NotBlank
	private int likeCount;

	@NotBlank
	private int member_id;
	@NotBlank
	private String email;
	@NotBlank
	private String name;
	@NotBlank
	private String profileImageUrl;
	
//	public BoardFindAllDetialDto(String title, String content, String location, String regDt,int readCount, int likeCount, int memberId, String email, String name, String profileImageUrl) {
		
//	}

//	
//	public BoardFindAllDetialDto(String title, String content, String location, String regDt, String member_id, String email, String name, String profileImageUrl) {
//		this.title = title;
//		this.content = content;
//		this.location = location;
//		this.regDt = regDt;
//		this.member_id = member_id;
//		this.email = email;
//		this.name = name;
//		this.profileImageUrl = profileImageUrl;
//	}
}
