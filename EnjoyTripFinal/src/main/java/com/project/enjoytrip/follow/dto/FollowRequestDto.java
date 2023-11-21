package com.project.enjoytrip.follow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FollowRequestDto {
	private String userEmailFrom;
    private String userEmailTo;
}
