package com.project.enjoytrip.board.dto;

import java.util.ArrayList;
import java.util.List;

import com.project.enjoytrip.board.entity.Board;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoardFindAllDto {
	List<Board> boardList = new ArrayList<>();
	private int page;
	private int size;
	private int totalPages;
	private int totalElements;
	public List<Board> getBoardList() {
		return boardList;
	}
}
