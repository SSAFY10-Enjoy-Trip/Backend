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

	public List<Board> getBoardList() {
		return boardList;
	}
}