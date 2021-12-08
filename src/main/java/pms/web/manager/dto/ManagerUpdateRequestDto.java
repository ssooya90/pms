package pms.web.manager.dto;

import pms.domain.manager.Manager;
import pms.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pms.domain.project.Project;

@Getter
@NoArgsConstructor
public class ManagerUpdateRequestDto {

	private Long id;
	private Project project;
	private String managerNm;
	private String managerTelNo;

	@Builder public ManagerUpdateRequestDto(Long id, String managerNm, String managerTelNo){
		this.id = id;
		this.managerNm = managerNm;
		this.managerTelNo = managerTelNo;
	}

	// Dto 객체를 entity 객체로 변환
	public Manager toEntity(){
		return Manager.builder()
				.id(id)
				.project(project)
				.managerNm(managerNm)
				.managerTelNo(managerTelNo)
				.build();
	}

}
