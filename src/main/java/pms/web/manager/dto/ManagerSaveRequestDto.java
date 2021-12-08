package pms.web.manager.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pms.domain.manager.Manager;
import pms.domain.member.Member;
import pms.domain.project.Project;

@Getter
@NoArgsConstructor
public class ManagerSaveRequestDto {

	private Project project;
	private String managerNm;
	private String managerTelNo;

	@Builder public ManagerSaveRequestDto(Project project, String managerNm, String managerTelNo){
		this.project = project;
		this.managerNm = managerNm;
		this.managerTelNo = managerTelNo;
	}

	// Dto 객체를 entity 객체로 변환
	public Manager toEntity(){
		return Manager.builder()
				.project(project)
				.managerNm(managerNm)
				.managerTelNo(managerTelNo)
				.build();
	}

}
