package pms.web;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pms.web.server.dto.ServerResponseDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.net.ssl.*;


@RequiredArgsConstructor
@Controller
public class IndexController {



	@GetMapping("/")
	public String main(Model model, final Pageable pageable) {

		try {
//			model.addAttribute("boardList",boardService.findBooksByPageRequest(pageable));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "index";
	}





}
