package com.project.enjoytrip.board.service;

import org.springframework.stereotype.Service;

import com.project.enjoytrip.board.dto.BoardDeleteDto;
import com.project.enjoytrip.board.dto.BoardFindAllDto;
import com.project.enjoytrip.board.dto.BoardFindDto;
import com.project.enjoytrip.board.dto.BoardInsertDto;
import com.project.enjoytrip.board.dto.BoardModifyDto;
import com.project.enjoytrip.board.entity.Board;
import com.project.enjoytrip.board.repository.BoardRepository;
import com.project.enjoytrip.member.dto.MemberFindDto;
import com.project.enjoytrip.member.entity.Member;
import com.project.enjoytrip.member.service.MemberService;

@Service
public class BoardServiceImpl implements BoardService {
	private MemberService memberService;
    private BoardRepository boardRepository;

    public BoardServiceImpl(MemberService memberService, BoardRepository boardRepository) {
        this.memberService = memberService;
        this.boardRepository = boardRepository;
    }

	@Override
	public BoardFindDto Find(BoardFindDto boardFindDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardFindAllDto FindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean Insert(BoardInsertDto boardInsertDto, int userId) {
		try {
            // BoardInsertDto에 있는 Member 필드를 직접 사용
			// memberId를 사용하여 Member 엔터티를 조회
			// MemberFindDto findDto = memberService.Find(new MemberFindDto(memberEmail, "", ""));
            Member member = new Member();
            member.setMemberId(userId);
            boardInsertDto.setMember(member);
            System.out.println(boardInsertDto);

            // BoardInsertDto를 사용하여 Board 엔터티를 생성
            Board board = boardInsertDto.toEntity();
            
            // 저장
            boardRepository.save(board);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Board Insert Service" + e.getMessage());
		}
		return false;
	}

	@Override
	public boolean Modify(BoardModifyDto boardModifyDto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean Delete(BoardDeleteDto boardDeleteDto) {
		// TODO Auto-generated method stub
		return false;
	}
}
