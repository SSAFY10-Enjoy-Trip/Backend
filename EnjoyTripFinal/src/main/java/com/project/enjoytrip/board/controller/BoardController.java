package com.project.enjoytrip.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.enjoytrip.auth.dto.LoginDto;
import com.project.enjoytrip.board.dto.BoardInsertDto;
import com.project.enjoytrip.board.entity.Board;
import com.project.enjoytrip.board.service.BoardService;

@RestController
public class BoardController {
	

	private BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}

	@PostMapping(value = "/tripBoard")
	public Map<String, String> Insert(@RequestBody BoardInsertDto boardInsertDto, HttpSession session) {
		
		System.out.println(boardInsertDto);
		LoginDto loginDto  = (LoginDto) session.getAttribute("user");
		System.out.println(loginDto.getMemberId());
		System.out.println("여기");
		System.out.println(session.getAttribute("user"));
		Map<String, String> map = new HashMap<>();
		if (boardService.Insert(boardInsertDto, 10)) {
			map.put("Board", "SUCCESS");
		} else {
			map.put("Board", "FAIL");
		}
		return map;
	}
	
	@GetMapping(value="/tripBoard")
	public Board Detail(int boardId) {
		return boardService.Detail(boardId);
	}
	

}
