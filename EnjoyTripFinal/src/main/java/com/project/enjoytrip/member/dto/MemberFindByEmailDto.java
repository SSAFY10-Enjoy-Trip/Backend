package com.project.enjoytrip.member.dto;

import javax.validation.constraints.NotBlank;

import com.project.enjoytrip.member.entity.Member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberFindByEmailDto {
	@NotBlank
	private String email;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String profileImageUrl;
	
	@Builder
	public MemberFindByEmailDto(String email, String name, String profileImageUrl) {
		this.email = email;
		this.name = name;
		this.profileImageUrl = profileImageUrl;
	}
	
	// 아래의 방법들은 Entity 사용에 있어 setter가 없어야 한다는 조건(보안) 때문에 잘 쓰지는 않지만
	// 학습 단계이기 때문에 편하니까 그냥 쓴다. 실무에서는 절대 사용하면 안된다고 했음.
	public Member toEntity() {
		return Member.builder()
				.email(email)
				.name(name)
				.profileImageUrl(profileImageUrl)
				.build();
	}
	
	public MemberFindByEmailDto toDto(Member member) {
		return MemberFindByEmailDto.builder()
				.email(member.getEmail())
				.name(member.getName())
				.profileImageUrl(member.getProfileImageUrl())
				.build();
	}
}
