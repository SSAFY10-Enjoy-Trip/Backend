package com.project.enjoytrip.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.enjoytrip.auth.dto.LoginDto;
import com.project.enjoytrip.board.dto.BoardInsertDto;
import com.project.enjoytrip.board.dto.BoardMatchDto;
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
		
		LoginDto loginDto  = (LoginDto) session.getAttribute("user");
		Map<String, String> map = new HashMap<>();
		if (boardService.Insert(boardInsertDto, loginDto.getMemberId())) {
			map.put("Board", "SUCCESS");
		} else {
			map.put("Board", "FAIL");
		}
		return map;
	}
	
	@GetMapping(value="/tripBoard/{boardId}")
	public Board Detail(@PathVariable int boardId) {
		return boardService.Detail(boardId);
	}

	@GetMapping(value="/tripBoard")
	public List<Board> FindAll() {
		System.out.println(boardService.FindAll().getBoardList());
		return boardService.FindAll().getBoardList();
	}
	@PostMapping(value="/tripBoard/check")
	public boolean IsWriter(@RequestBody BoardMatchDto boardMatchDto, HttpSession session) {
		LoginDto loginDto = (LoginDto) session.getAttribute("user");
		boolean result = boardService.IsWriter(boardMatchDto, loginDto.getMemberId());
		System.out.println("결과 : " + result);
		return result ;
	}


}
