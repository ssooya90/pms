package pms.service.manager;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pms.domain.manager.Manager;
import pms.domain.manager.ManagerRepository;
import pms.domain.member.Member;
import pms.domain.member.MemberRepository;
import pms.domain.project.Project;
import pms.domain.project.ProjectRepository;
import pms.web.manager.dto.ManagerResponseDto;
import pms.web.manager.dto.ManagerSaveRequestDto;
import pms.web.manager.dto.ManagerUpdateRequestDto;

import java.security.Principal;

@RequiredArgsConstructor
@Service
public class ManagerService {

	Logger logger = LoggerFactory.getLogger(ManagerService.class);

	private final ProjectRepository projectRepository;
	private final ManagerRepository managerRepository;

	public Long save(ManagerSaveRequestDto requestDto, Principal principal) {

//		Project project = projectRepository.findById(principal.getName()).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다"));

		requestDto = ManagerSaveRequestDto.builder()
				.project(Project.builder().build())
				.managerNm(requestDto.getManagerNm())
				.managerTelNo(requestDto.getManagerTelNo())
				.build();

		return managerRepository.save(requestDto.toEntity()).getId();

	}

	public Page findManagerByPageRequest(Pageable pageable, String member_id) {
		Page<Manager> page = managerRepository.findAllByMemberId(pageable, member_id);


		return page;

//		return page.stream().map(ManagerResponseDto::new).collect(Collectors.toList());


	}

	@Transactional
	public ManagerResponseDto findById(Long id) {

		Manager entity = managerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 담당자가 없습니다"));

		return new ManagerResponseDto(entity);


	}


	@Transactional
	public Long update(ManagerUpdateRequestDto requestDto) {

		return managerRepository.save(requestDto.toEntity()).getId();
	}
}
