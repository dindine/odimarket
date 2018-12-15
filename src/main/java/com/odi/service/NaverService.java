package com.odi.service;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.odi.api.NaverLoginApi;
import com.odi.domain.NaverLogin;
import com.odi.domain.UserVO;

@Service
public class NaverService {
	private final static String CLIENT_ID = "eDavDVk3glwtWcYaYm49";
	private final static String CLIENT_SECRET = "fFaKt5PeF6";
	private final static String REDIRECT_URI = "http://localhost:8080/odi/naver/callback.do";
	private final static String SESSION_STATE = "oauth_state";
	private final static String PROFILE_API_URL = "https://openapi.naver.com/v1/nid/me";

	@Autowired
	private NaverLoginApi naverLoginApi;

	public OAuth20Service getQAuthService(String state) {
		ServiceBuilder builder = new ServiceBuilder();
		if (state != null) {
			builder.state(state);
		}

		return builder.apiKey(CLIENT_ID)
				.apiSecret(CLIENT_SECRET)
				.callback(REDIRECT_URI)
				.build(naverLoginApi);
	}

	public String getAuthorizationUrl(HttpSession session) {
		String state = generateRandomString();
		setSession(session, state);

		return getQAuthService(state).getAuthorizationUrl();
	}

	public UserVO getUserProfile(HttpSession session, String code, String state) throws IOException {
		OAuth2AccessToken oauthToken = getAccessToken(session, code, state);
		String response = requestUserProfile(oauthToken);

		ObjectMapper objectMapper = new ObjectMapper();
		NaverLogin result = objectMapper.readValue(response, NaverLogin.class);

		System.out.println("(naver_service)response : " + response);
		return responseToUser(result.getResponse());
	}

	private UserVO responseToUser(NaverLogin.Response response) {
		return new UserVO.Builder()
				.id(response.getId())
				.email(response.getEmail())
				.nickname(response.getNickname())
				.loginType(UserVO.LoginType.Naver.name())
				.build();
	}

	private OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException {
		String sessionState = getSession(session);

		if (StringUtils.pathEquals(sessionState, state)) {
			return getQAuthService(state).getAccessToken(code);
		}

		return null;
	}

	private String requestUserProfile(OAuth2AccessToken oauthToken) throws IOException {
		OAuth20Service oauthService = getQAuthService(null);
		OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);

		oauthService.signRequest(oauthToken, request);

		Response response = request.send();

		return response.getBody();
	}

	private String generateRandomString() {
		return UUID.randomUUID().toString();
	}

	private void setSession(HttpSession session, String state) {
		session.setAttribute(SESSION_STATE, state);
	}

	private String getSession(HttpSession session) {
		return (String) session.getAttribute(SESSION_STATE);
	}
}