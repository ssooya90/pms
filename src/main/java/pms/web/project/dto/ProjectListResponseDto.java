package pms.web.project.dto;

import lombok.Getter;
import pms.domain.member.Member;
import pms.domain.project.Project;

import java.time.LocalDateTime;

@Getter
public class ProjectListResponseDto {

	private Long id;
	private Member member;
	private String name;
	private String description;
	private String price;
	private String parent;
	private String state;
	private String stateName;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;

	public String state(String stateCode){

		String state = "";

		switch (stateCode){

			case "1" :
				state =  "대기";
				break;
			case "2" :
				state =  "진행중";
				break;
			case "3" :
				state =  "완료";
				break;
		}

		return state;

	}

	// Board entity에서 일부만 사용하기때문에, 생성자롤 eneity를 받아 필드에 넣는다.
	public ProjectListResponseDto(Project entity) {
		this.id = entity.getId();
		this.member = entity.getMember();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
		this.parent = entity.getParent();
		this.state = entity.getState();
		this.stateName = state(entity.getState());
		this.createdDate = entity.getCreatedDate();
		this.modifiedDate = entity.getModifiedDate();
	}

}
