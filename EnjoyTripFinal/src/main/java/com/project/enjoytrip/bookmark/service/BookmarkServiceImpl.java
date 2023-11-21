package com.project.enjoytrip.bookmark.service;

import org.springframework.stereotype.Service;

import com.project.enjoytrip.board.entity.Board;
import com.project.enjoytrip.bookmark.entity.Bookmark;
import com.project.enjoytrip.bookmark.entity.BookmarkId;
import com.project.enjoytrip.bookmark.repository.BookmarkRepositorty;
import com.project.enjoytrip.member.entity.Member;

@Service
public class BookmarkServiceImpl implements BookmarkService {
    private BookmarkRepositorty bookmarkRepository;

    public BookmarkServiceImpl(BookmarkRepositorty bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }
    
	@Override
	public boolean addHeart(int boardId, int userId) {
//		Member member = new Member();
//		Board board = new Board();
//		
//		member.setMemberId(userId);
//		board.setBoardId(boardId);
//		
//		 BookmarkId bookmarkId = new BookmarkId(member, board);
//
//	        // 해당 복합키로 저장된 Bookmark가 이미 존재하는지 확인
//	        if (bookmarkRepository.existsById(bookmarkId)) {
//	        	bookmarkRepository.deleteById(bookmarkId);
//
//	            return true;
//	        }
//
//	        // 복합키로 Bookmark 생성
//	        Bookmark bookmark = new Bookmark(bookmarkId);
//
//	        // 저장
//	        bookmarkRepository.save(bookmark);

	        return true;
	}

}
