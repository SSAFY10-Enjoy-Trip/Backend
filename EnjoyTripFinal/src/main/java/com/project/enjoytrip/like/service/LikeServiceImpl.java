package com.project.enjoytrip.like.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

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

}
