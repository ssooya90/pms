package pms.domain.manager;

import pms.domain.BaseTimeEntity;
import pms.domain.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pms.domain.project.Project;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "TB_MANAGER")
public class Manager extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manager_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "project_id" , updatable = false)
	private Project project;

	@Column(length = 100, nullable = false)
	private String managerNm;

	@Column(length = 100, nullable = false)
	private String managerTelNo;

	@Column(length = 100, nullable = false)
	private String managerPhoneNo;

	@Builder
	public Manager(Long id, Project project, String managerNm, String managerTelNo, String managerPhoneNo) {
		this.id = id;
		this.project = project;
		this.managerNm = managerNm;
		this.managerTelNo = managerTelNo;
		this.managerPhoneNo = managerPhoneNo;
	}
}
