package com.odi.biz.user.api;

import org.springframework.stereotype.Component;

import com.github.scribejava.core.builder.api.DefaultApi20;

@Component
public class NaverLoginApi extends DefaultApi20 {

	private static final String AUTHORIZATION_BASE_URL = "https://nid.naver.com/oauth2.0/authorize";
	private static final String ACCESS_TOKEN_END_POINT = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";

	@Override
	public String getAccessTokenEndpoint() {
		return ACCESS_TOKEN_END_POINT;
	}

	@Override
	protected String getAuthorizationBaseUrl() {
		return AUTHORIZATION_BASE_URL;
	}
}