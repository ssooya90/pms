package pms.domain.manager;

import pms.domain.BaseTimeEntity;
import pms.domain.member.Member;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
	@JoinColumn(name = "member_id" , updatable = false)
	private Member member;

	@Column(length = 100, nullable = false)
	private String managerNm;

	@Column(length = 100, nullable = false)
	private String managerTelNo;

	@Builder
	public Manager(Long id, Member member, String managerNm, String managerTelNo) {
		this.id = id;
		this.member = member;
		this.managerNm = managerNm;
		this.managerTelNo = managerTelNo;
	}
}
