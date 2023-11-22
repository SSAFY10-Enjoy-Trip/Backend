package com.project.enjoytrip.board.service;

import com.project.enjoytrip.board.dto.BoardDeleteDto;
import com.project.enjoytrip.board.dto.BoardFindAllDto;
import com.project.enjoytrip.board.dto.BoardInsertDto;
import com.project.enjoytrip.board.dto.BoardMatchDto;
import com.project.enjoytrip.board.dto.BoardModifyDto;
import com.project.enjoytrip.board.entity.Board;

public interface BoardService {

	public Board Detail(int boardId);
	public BoardFindAllDto FindAll(int page, int size);
	public boolean Insert(BoardInsertDto boardRegisterDto, int userId);
	public boolean Modify(BoardModifyDto boardModifyDto);
	public boolean Delete(BoardDeleteDto boardDeleteDto);
	public boolean IsWriter(BoardMatchDto boardMatchDto, int memberId);
}
