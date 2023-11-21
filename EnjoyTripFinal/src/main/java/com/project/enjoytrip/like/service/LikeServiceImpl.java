package com.project.enjoytrip.like.service;

import org.springframework.stereotype.Service;

import com.project.enjoytrip.like.dto.LikeUpdateDto;
import com.project.enjoytrip.like.entity.Like;
import com.project.enjoytrip.like.repository.LikeRepositorty;

@Service
public class LikeServiceImpl implements LikeService {
    private LikeRepositorty likeRepository;

    public LikeServiceImpl(LikeRepositorty likeRepository) {
        this.likeRepository = likeRepository;
    }
    
	@Override
	public boolean addHeart(int boardId, int userId) {
//	        // 해당 복합키로 저장된 Bookmark가 이미 존재하는지 확인
//	        if (likeRepository.existByBoardIdAndUserId(boardId, userId)) {
//	        	likeRepository.deleteByBoardIdAndUserId(boardId, userId);
//
//	            return true;
//	        }
//	        else {
//	        	Like like = new Like(boardId, userId);
//		        // 저장
//		        likeRepository.save(like);
//	        }
	        return true;
	}

}
