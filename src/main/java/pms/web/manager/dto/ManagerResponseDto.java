package pms.web.manager.dto;

import lombok.Getter;
import pms.domain.manager.Manager;
import pms.domain.member.Member;
import pms.domain.project.Project;

import java.time.LocalDateTime;

@Getter
public class ManagerResponseDto {

	private Long id;
	private Project project;
	private String managerNm;
	private String managerTelNo;
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;


	public ManagerResponseDto(Manager entity) {
		this.id = entity.getId();
		this.project = entity.getProject();
		this.managerNm = entity.getManagerNm();
		this.managerTelNo = entity.getManagerTelNo();
		this.createdDate = entity.getCreatedDate();
		this.modifiedDate = entity.getModifiedDate();
	}

}
