package pms.web;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

	@GetMapping("/")
	public String main(Model model, final Pageable pageable){

		try{
//			model.addAttribute("boardList",boardService.findBooksByPageRequest(pageable));
		}catch (Exception e){
			e.printStackTrace();
		}

		return "index";
	}


}
