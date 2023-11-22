package com.project.enjoytrip.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.project.enjoytrip.board.dto.BoardDeleteDto;
import com.project.enjoytrip.board.dto.BoardFindAllDetialDto;
import com.project.enjoytrip.board.dto.BoardFindAllDto;
import com.project.enjoytrip.board.dto.BoardInsertDto;
import com.project.enjoytrip.board.dto.BoardMatchDto;
import com.project.enjoytrip.board.dto.BoardModifyDto;
import com.project.enjoytrip.board.entity.Board;
import com.project.enjoytrip.board.repository.BoardRepository;
import com.project.enjoytrip.like.service.LikeService;
import com.project.enjoytrip.member.entity.Member;
import com.project.enjoytrip.member.service.MemberService;

@Service
public class BoardServiceImpl implements BoardService {
	private MemberService memberService;
    private BoardRepository boardRepository;
    private LikeService likeService;

    public BoardServiceImpl(MemberService memberService, BoardRepository boardRepository, LikeService likeService) {
        this.memberService = memberService;
        this.boardRepository = boardRepository;
        this.likeService = likeService;
    }

	@Override
	public Board Detail(int boardId) {
		Optional<Board> detail = boardRepository.findById(boardId);
		Board board = detail.get();
		int likeCount = likeService.likeCount(board.getBoardId(), board.getMember().getMemberId());
		board.setLikeCount(likeCount);
		
		board.setReadCount(board.getReadCount()+1);
		boardRepository.save(board);
		return board;
	}

	@Override
	public BoardFindAllDto FindAll(int page, int size) {
		PageRequest pageable = PageRequest.of(page, size, Sort.by("regDt").descending());

	    Page<Board> boardPage = boardRepository.findAll(pageable);
	    List<Board> dto = boardPage.getContent();
	    List<BoardFindAllDetialDto> boardList = new ArrayList<>();
	    BoardFindAllDto allDto = new BoardFindAllDto();

	    for (Board board : dto) {
	        int likeCount = likeService.likeCount(board.getBoardId(), board.getMember().getMemberId());
	        board.setLikeCount(likeCount);
	        //String title, String content, String location,
			//String regDt, Member member
	        boardList.add(new BoardFindAllDetialDto(board.getBoardId(), board.getTitle(), board.getContent(), board.getLocation(), board.getRegDt().toString(), board.getReadCount(), board.getLikeCount(), board.getMember().getMemberId(), board.getMember().getEmail(), board.getMember().getName(), board.getMember().getProfileImageUrl()));
	    }

	    allDto.setBoardList(boardList);
	    allDto.setTotalPages(boardPage.getTotalPages());
	    allDto.setTotalElements((int) boardRepository.count());
        
        return allDto;
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

	@Override
	public boolean IsWriter(BoardMatchDto boardMatchDto, int userId) {
		return boardRepository.existsByBoardIdAndMember_MemberId(boardMatchDto.getBoardId(), userId);
	}
}
