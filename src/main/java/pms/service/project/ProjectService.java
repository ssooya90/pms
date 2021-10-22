package pms.service.project;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pms.domain.member.Member;
import pms.domain.member.MemberRepository;
import pms.domain.project.Project;
import pms.domain.project.ProjectRepository;
import pms.web.project.dto.ProjectListResponseDto;
import pms.web.project.dto.ProjectRegRequestDto;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class ProjectService {

	Logger logger = LoggerFactory.getLogger(ProjectService.class);

	private final ProjectRepository projectRepository;
	private final MemberRepository memberRepository;

	@Transactional
	public Long save(ProjectRegRequestDto requestDto, Principal principal){

		Member member = memberRepository.findByUserId(principal.getName()).orElseThrow(() -> new IllegalArgumentException("해당 아이디가 없습니다"));

		requestDto = ProjectRegRequestDto.builder()
				.member(member)
				.name(requestDto.getName())
				.description(requestDto.getDescription())
				.price(requestDto.getPrice())
				.parent(requestDto.getParent())
				.state(requestDto.getState())
				.build();

		return projectRepository.save(requestDto.toEntity()).getId();
	}


	@Transactional(readOnly = true)
	public List findProjectByPageRequest(Pageable pageable, Map map) {

		Page<Project> page = null;

		page = projectRepository.findAllSearch("88", pageable);

//		if(map.get("searchFlag").equals("name")){
//		}else{
//			page = projectRepository.findAll(pageable);
//		}


		return page.stream().map(ProjectListResponseDto::new).collect(Collectors.toList());
	}



	// 아이디로 단일 객체 가져오기
	@Transactional(readOnly = true)
	public ProjectListResponseDto findById(Long id) {

		Project entity = projectRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));

		return new ProjectListResponseDto(entity);

	}
}
