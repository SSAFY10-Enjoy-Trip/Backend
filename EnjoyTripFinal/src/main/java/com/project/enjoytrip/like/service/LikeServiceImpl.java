package com.project.enjoytrip.like.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.project.enjoytrip.board.dto.BoardFindAllDetialDto;
import com.project.enjoytrip.board.entity.Board;
import com.project.enjoytrip.board.repository.BoardRepository;
import com.project.enjoytrip.board.service.BoardService;
import com.project.enjoytrip.like.entity.Like;
import com.project.enjoytrip.like.repository.LikeRepositorty;

@Service
public class LikeServiceImpl implements LikeService {
    private LikeRepositorty likeRepository;
    
    public LikeServiceImpl(LikeRepositorty likeRepository) {
        this.likeRepository = likeRepository;
    }
    
	@Override
	@Transactional
	public boolean addHeart(int boardId, int userId) {
	        // 이미 좋아요를 했는지 확인
	        if (amIHeart(boardId, userId)) {
	        	likeRepository.deleteByBoardIdAndUserId(boardId, userId);
	            return true;
	        }
	        else {
	        	Like like = new Like(boardId, userId);
		        // 저장
		        likeRepository.save(like);
	        }
	        return true;
	}

	@Override
	public boolean amIHeart(int boardId, int userId) {
		return likeRepository.existsByBoardIdAndUserId(boardId, userId);
	}

	@Override
	public int likeCount(int boardId, int memberId) {
		return likeRepository.countByBoardIdAndUserId(boardId, memberId);
	}
	public int likeCountJustBoard(int boardId) {
		return likeRepository.countByBoardId(boardId);
	}

	@Override
	public List<Like> findByUserId(int memberId) {
		// TODO Auto-generated method stub
		return likeRepository.findByUserId(memberId);
	}


}
