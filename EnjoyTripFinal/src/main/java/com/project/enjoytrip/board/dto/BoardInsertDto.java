package com.project.enjoytrip.board.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.project.enjoytrip.board.entity.Board;
import com.project.enjoytrip.member.entity.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardInsertDto {
	@NotBlank
	private String title;
	@NotBlank
	private String content;
	@NotBlank
	private String location;
	@NotBlank
	private String regDt;

	@NotBlank
	private Member member;
	
	@Builder
	public BoardInsertDto(String title, String content, String location) {
		this.title = title;
		this.content = content;
		this.location = location;
		this.regDt = LocalDateTime.now().toString();
	}
	
	public Board toEntity() {
		return new Board(member, title, content, location, LocalDateTime.now());
	}

	public BoardInsertDto(@NotBlank String title, @NotBlank String content, @NotBlank String location,
			@NotBlank String regDt, @NotBlank Member member) {
		super();
		this.title = title;
		this.content = content;
		this.location = location;
		this.regDt = regDt;
		this.member = member;
	}
	
	
}
