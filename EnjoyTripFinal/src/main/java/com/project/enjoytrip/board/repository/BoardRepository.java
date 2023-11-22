package com.project.enjoytrip.board.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.project.enjoytrip.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

	 boolean existsByBoardIdAndMember_MemberId(int boardId, int userId);
	 
	 @Query("SELECT new com.example.dto.BoardDetailsDTO(tb.userId, tb.boardId, tb.title, tb.content, tb.regDt, COUNT(bl.boardId) AS like_count, tb.readCount, tb.location) " +
	           "FROM BoardLike bl " +
	           "INNER JOIN TripBoard tb ON bl.boardId = tb.boardId " +
	           "WHERE bl.boardId = :boardId " +
	           "GROUP BY tb.userId, tb.boardId, tb.title, tb.content, tb.regDt, tb.readCount, tb.location " + 
	           "limit 1 ")
	 Board getBoardDetailsByBoardId(@Param("boardId") int boardId);

}
