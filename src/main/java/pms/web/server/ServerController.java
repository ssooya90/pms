package pms.web.server;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pms.service.server.ServerService;
import pms.web.server.dto.ServerResponseDto;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ServerController {

	private final ServerService serverService;

	@ResponseBody
	@GetMapping("/serverCheck")
	public List<ServerResponseDto> serverCheck() throws Exception {

		List<ServerResponseDto> serverResponseDtoList = new ArrayList();
		HashMap<String , String> siteMap = new HashMap<>();

		// 추후 DB처리
		siteMap.put("냉매(사용자)","https://www.rims.or.kr");
		siteMap.put("냉매(관리자)","https://www.rims.or.kr/RIMSADMIN");
		siteMap.put("환경사랑공모전(사용자)","https://contest.keco.or.kr");
		siteMap.put("환경사랑공모전(관리자)","https://contest.keco.or.kr/infra/");
		siteMap.put("환경사랑공모전(심사위원)","https://contest.keco.or.kr/panel/");
		siteMap.put("재비산","https://www.cleanroad.or.kr/");
		siteMap.put("층간소음","https://floor.noiseinfo.or.kr/floornoise/");
		siteMap.put("좋은빛","https://www.goodlight.or.kr/");
		siteMap.put("한국환경공단","https://www.keco.or.kr/");
		siteMap.put("비점오염","https://www.nonpoint.or.kr");

		try {

			for( String key : siteMap.keySet() ){
				System.out.println(key);

				if(siteMap.get(key).startsWith("https")){
					serverResponseDtoList.add(serverService.httpsProc(key, siteMap.get(key)));
				}else if(siteMap.get(key).startsWith("http")){
					serverResponseDtoList.add(serverService.httpProc(key, siteMap.get(key)));
				}
			}

		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException : " + e);
		} catch (IOException e) {
			System.out.println("IOException :" + e);
		} catch (Exception e) {
			System.out.println("error : " + e);
		}

		return serverResponseDtoList;


	}
}
