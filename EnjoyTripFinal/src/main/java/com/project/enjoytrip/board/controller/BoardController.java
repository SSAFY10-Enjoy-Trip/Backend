package com.project.enjoytrip.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.enjoytrip.board.dto.BoardInsertDto;
import com.project.enjoytrip.board.service.BoardService;

@RestController
public class BoardController {
	

	private BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@PostMapping(value = "/board")
	public Map<String, String> Follow(BoardInsertDto boardInsertDto, int userId) {
		Map<String, String> map = new HashMap<>();
		if (boardService.Insert(boardInsertDto, userId)) {
			map.put("Board", "SUCCESS");
		} else {
			map.put("Board", "FAIL");
		}
		return map;
	}

}
