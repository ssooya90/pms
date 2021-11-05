package pms.service.server;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pms.web.server.dto.ServerResponseDto;

import javax.net.ssl.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ServerService {

	Logger logger = LoggerFactory.getLogger(ServerService.class);

	/**
	 * http 리턴
	 *
	 * @param siteName
	 * @param urlStr
	 * @return
	 * @throws Exception
	 */
	public ServerResponseDto httpProc(String siteName, String urlStr) throws Exception {

		HttpURLConnection httpConn = null;
		URL url = new URL(urlStr);

		ServerResponseDto serverResponseDto = new ServerResponseDto();
		LocalDateTime localDateTime = LocalDateTime.now();

		serverResponseDto.setServerName(siteName);
		serverResponseDto.setCheckDate(localDateTime);

		try {
			httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setRequestMethod("GET");
			httpConn.connect();

			int responseCode = httpConn.getResponseCode();
			serverResponseDto.setServerCode(responseCode);
			serverResponseDto.setServerState("정상");
		} catch (Exception e) {
			serverResponseDto.setServerState("에러");
		}

		httpConn.disconnect();
		return serverResponseDto;


	}

	/**
	 * https 리턴
	 *
	 * @param siteName
	 * @param urlStr
	 * @return
	 * @throws Exception
	 */
	public ServerResponseDto httpsProc(String siteName, String urlStr) throws Exception {

		HttpsURLConnection httpsConn = null;
		URL url = new URL(urlStr);
		httpsConn = (HttpsURLConnection) url.openConnection();

		httpsConn.setHostnameVerifier(new HostnameVerifier() {
			@Override
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		});

		TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		}};

		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		httpsConn.setRequestMethod("GET");
		int responseCode = httpsConn.getResponseCode();
		LocalDateTime localDateTime = LocalDateTime.now();

		// SSL
		SSLContext context = SSLContext.getInstance("TLS");
		context.init(null, null, null); // No validation for now
		httpsConn.setSSLSocketFactory(context.getSocketFactory());

		ServerResponseDto serverResponseDto = new ServerResponseDto();
		serverResponseDto.setServerName(siteName);
		serverResponseDto.setServerCode(responseCode);
		serverResponseDto.setServerState(responseCode == 200 ? "정상" : "에러");
		serverResponseDto.setCheckDate(localDateTime);

		httpsConn.disconnect();

		return serverResponseDto;

	}

}
