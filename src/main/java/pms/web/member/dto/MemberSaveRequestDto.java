package pms.web.member.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pms.domain.member.Member;

/**
 * Created by ssooya90@naver.com on 2020-02-24
 * Github : http://github.com/ssooya90
 */

@Getter
@NoArgsConstructor
public class MemberSaveRequestDto {

	private String userId;
	private String password;
	private String corpNm;
	private String name;
	private String email;
	private String telNo;

	@Builder
	public MemberSaveRequestDto(String userId, String password, String corpNm, String name, String email, String telNo){
		this.userId = userId;
		this.password = password;
		this.corpNm = corpNm;
		this.name = name;
		this.email = email;
		this.telNo = telNo;
	}

	public Member toEntity(){
		return Member.builder()
				.userId(userId)
				.password(password)
				.corpNm(corpNm)
				.name(name)
				.email(email)
				.telNo(telNo)
				.build();
	}
	// 비밀번호 암호화용
	public void setPw(String password) {
		this.password = password;
	}


}
