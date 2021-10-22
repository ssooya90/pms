package pms.domain.member;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MemberRole {

	MEMBER("ROLE_MEMBER"),
	ADMIN("ROLE_ADMIN");

	private String value;
}

