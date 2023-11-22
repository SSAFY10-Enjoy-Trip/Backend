package com.project.enjoytrip.board.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardFindAllDto {
	List<BoardFindAllDetialDto> boardList = new ArrayList<>();
	private int page;
	private int size;
	private int totalPages;
	private int totalElements;
	public List<BoardFindAllDetialDto> getBoardList() {
		return boardList;
	}
}
