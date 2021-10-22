package pms.domain.member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pms.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "TB_MEMBER")
public class Member extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;

	@Column(length = 10, nullable = false, unique = true) // 유니크 설정
	private String userId;

	@Column(length = 100, nullable = false)
	private String password;

	@Column(length = 100, nullable = false)
	private String name;

	@Column(length = 100, nullable = false)
	private String email;

	@Column(length = 100, nullable = false)
	private String picture;

	@Column(length = 100, nullable = false)
	private String corpNm;

	@Column(length = 100, nullable = false)
	private String telNo;

	@Enumerated(EnumType.STRING)
	@Column
	private MemberRole role;

	@Builder
	public Member(Long id, String userId, String password, String name, String email, String picture, String corpNm, String telNo, MemberRole role) {
		this.id = id;
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.picture = picture;
		this.corpNm = corpNm;
		this.telNo = telNo;
		this.role = role;
	}
}
