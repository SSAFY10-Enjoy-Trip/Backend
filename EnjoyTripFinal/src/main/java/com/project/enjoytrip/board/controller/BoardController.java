package com.project.enjoytrip.board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.project.enjoytrip.auth.dto.LoginDto;
import com.project.enjoytrip.board.dto.BoardFindAllDto;
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

	@PostMapping(value="/tripBoard/all")
	public Map<String, String> FindAll(@RequestBody BoardFindAllDto boardFindAllDto) {
		System.out.println("나 이거 받았엉");
		System.out.println(boardFindAllDto);
		BoardFindAllDto boardDto = boardService.FindAll(boardFindAllDto.getPage(), boardFindAllDto.getSize());
		Map<String, String> map = new HashMap<>();
		
		
	    Gson gson = new Gson();
	    String boardListJson = gson.toJson(boardDto.getBoardList());
	    
	    System.out.println(boardListJson);
		
		map.put("board", boardListJson);
		map.put("totalPages", Integer.toString(boardDto.getTotalPages()));
		map.put("totalElements", Integer.toString(boardDto.getTotalElements()));
		return map;
	}
	@PostMapping(value="/tripBoard/check")
	public boolean IsWriter(@RequestBody BoardMatchDto boardMatchDto, HttpSession session) {
		LoginDto loginDto = (LoginDto) session.getAttribute("user");
		boolean result = boardService.IsWriter(boardMatchDto, loginDto.getMemberId());
		System.out.println("결과 : " + result);
		return result ;
	}


}
