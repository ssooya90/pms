package pms.domain.project;
import pms.domain.BaseTimeEntity;
import pms.domain.manager.Manager;
import pms.domain.member.Member;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "TB_PROJECT")
public class Project extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	@ManyToOne
	@JoinColumn(name = "manager_id")
	private Manager manager;

	@Column(length = 100, nullable = false)
	private String name;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String description;

	@Column(length = 100, nullable = true)
	private String parent;

	@Column(length = 100, nullable = false)
	private String state;

	@Column(length = 100, nullable = false)
	private String price;

	@Builder
	public Project(Long id, Member member, Manager manager, String name, String description , String parent, String state , String price ) {
		this.id = id;
		this.member = member;
		this.manager = manager;
		this.name = name;
		this.description = description;
		this.parent = parent;
		this.state = state;
		this.price = price;
	}
}
