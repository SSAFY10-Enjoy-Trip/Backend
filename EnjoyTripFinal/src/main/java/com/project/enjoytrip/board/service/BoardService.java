package com.project.enjoytrip.board.service;

import com.project.enjoytrip.board.dto.BoardDeleteDto;
import com.project.enjoytrip.board.dto.BoardFindAllDto;
import com.project.enjoytrip.board.dto.BoardFindDto;
import com.project.enjoytrip.board.dto.BoardInsertDto;
import com.project.enjoytrip.board.dto.BoardModifyDto;

public interface BoardService {

	public BoardFindDto Find(BoardFindDto boardFindDto);
	public BoardFindAllDto FindAll();
	public boolean Insert(BoardInsertDto boardRegisterDto, int userId);
	public boolean Modify(BoardModifyDto boardModifyDto);
	public boolean Delete(BoardDeleteDto boardDeleteDto);
}
