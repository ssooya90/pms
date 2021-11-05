package pms.web.server.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ServerResponseDto {

	private String serverName;
	private int serverCode;
	private String serverState;
	private LocalDateTime checkDate;


}
