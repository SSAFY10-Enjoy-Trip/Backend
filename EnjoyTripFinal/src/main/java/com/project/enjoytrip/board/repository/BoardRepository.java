package com.project.enjoytrip.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.enjoytrip.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
