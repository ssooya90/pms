package pms.web.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pms.service.member.MemberService;
import pms.web.member.dto.MemberSaveRequestDto;

@RequiredArgsConstructor
@Controller
public class MemberController {

	private final MemberService memberService;
	private final PasswordEncoder passwordEncoder;



	@GetMapping("/sign/signup")
	public String signup() {
		return "/sign/signup";
	}

	@GetMapping("/sign/signin")
	public String memberLogin() {
		return "/sign/signin";
	}

	@GetMapping("/loginSuccess")
	public String loginSuccess(Model model) {
		return "/sign/loginSuccess";
	}


	@PostMapping("/sign/signup")
	@ResponseBody
	public Long save(@RequestBody MemberSaveRequestDto requestDto) {

		requestDto.setPw(passwordEncoder.encode(requestDto.getPassword()));
		Long id = memberService.save(requestDto);

		return id;
	}


}

