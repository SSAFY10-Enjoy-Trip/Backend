package com.project.enjoytrip.follow.dto;

import javax.validation.constraints.NotBlank;

import com.project.enjoytrip.follow.entity.FollowId;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FollowDto {
//	@NotBlank
//	private int userIdFrom;
//	
//	@NotBlank
//	private int userIdTo;
//	
//	
//	@Builder
//	public FollowDto(int userIdFrom, int userIdTo) {
//		this.userIdFrom = userIdFrom;
//		this.userIdTo = userIdTo;
//	}
//	
//	// 아래의 방법들은 Entity 사용에 있어 setter가 없어야 한다는 조건(보안) 때문에 잘 쓰지는 않지만
//	// 학습 단계이기 때문에 편하니까 그냥 쓴다. 실무에서는 절대 사용하면 안된다고 했음.
//	public FollowId toEntity() {
//		return FollowId.builder()
//				.userIdFrom(userIdFrom)
//				.userIdTo(userIdTo)
//				.build();
//	}
//	
//	public FollowDto toDto(FollowId followId) {
//		return FollowDto.builder()
//				.userIdFrom(followId.getUserIdFrom())
//				.userIdTo(followId.getUserIdTo())
//				.build();
//	}
}
