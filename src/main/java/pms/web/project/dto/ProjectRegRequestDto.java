package pms.web.project.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pms.domain.member.Member;
import pms.domain.project.Project;

@Getter
@NoArgsConstructor
public class ProjectRegRequestDto {


	private Member member;
	private String userId;
	private String name;
	private String description;
	private String price;
	private String parent;
	private String state;


	@Builder
	public ProjectRegRequestDto(Member member, String userId, String name, String description, String price , String state, String parent){
		this.member = member;
		this.userId = userId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.parent = parent;
		this.state = state;
	}

	// repository에서는 entity로 접근되어야하기때문에 다시 변환
	public Project toEntity(){
		return Project.builder()
				.member(member)
				.name(name)
				.description(description)
				.price(price)
				.parent(parent)
				.parent(parent)
				.state(state)
				.build();
	}




}
