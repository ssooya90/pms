package pms.web.manager.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pms.domain.manager.Manager;
import pms.domain.member.Member;

@Getter
@NoArgsConstructor
public class ManagerSaveRequestDto {

	private Member member;
	private String managerNm;
	private String managerTelNo;

	@Builder public ManagerSaveRequestDto(Member member, String managerNm, String managerTelNo){
		this.member = member;
		this.managerNm = managerNm;
		this.managerTelNo = managerTelNo;
	}

	// Dto 객체를 entity 객체로 변환
	public Manager toEntity(){
		return Manager.builder()
				.member(member)
				.managerNm(managerNm)
				.managerTelNo(managerTelNo)
				.build();
	}

}
