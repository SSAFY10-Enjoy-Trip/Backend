package com.project.enjoytrip.like.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LikeUpdateDto {
    private int likeId;
    private int userId;
    private int boardId;
    
    public LikeUpdateDto(int boardId, int userId) {
    	this.boardId = boardId;
    	this.userId = userId;
    }

}
