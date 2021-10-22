package pms.web.project;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pms.service.project.ProjectService;
import pms.web.project.dto.ProjectListResponseDto;
import pms.web.project.dto.ProjectRegRequestDto;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class ProjectController {

	private final ProjectService projectService;

	@GetMapping("/project/list")
	public String projectList(Model model, final Pageable pageable){

		Map map = new HashMap<>();

		model.addAttribute("currentNum","01");
		model.addAttribute("projectList",projectService.findProjectByPageRequest(pageable, map));


//		if(1==1){
//			model.addAttribute("commentList",projectService.findByBoard_Id(id));
//		}

		return "/project/project_list";
	}

	@GetMapping("/project/edit/{id}")
	public String detail(@PathVariable("id") Long id, Model model){

		ProjectListResponseDto projectListResponseDto = projectService.findById(id);
		model.addAttribute("projectDto", projectListResponseDto);

		return "/project/project_edit";
	}

	@GetMapping("/project/reg")
	public String projectReg(){

		return "/project/project_reg";
	}

	@PostMapping("/project/reg")
	@ResponseBody
	public Long projectReg(@RequestBody ProjectRegRequestDto requestDto, Principal principal, Model model){

		return projectService.save(requestDto, principal);
	}






	@GetMapping("/project/edit")
	public String projectEdit(){
		return "/project/project_edit";
	}
}
