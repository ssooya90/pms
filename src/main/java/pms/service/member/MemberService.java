package pms.service.member;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pms.domain.member.MemberRepository;
import pms.web.member.dto.MemberSaveRequestDto;

@RequiredArgsConstructor
@Service
public class MemberService {

	Logger logger = LoggerFactory.getLogger(MemberService.class);

	private final MemberRepository memberRepository;


	@Transactional
	public Long save(MemberSaveRequestDto requestDto){
		return memberRepository.save(requestDto.toEntity()).getId();
	}


}
