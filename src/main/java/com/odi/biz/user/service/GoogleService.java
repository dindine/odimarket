package com.odi.biz.user.service;

import static com.odi.utils.StringUtils.nullToEmpty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.api.plus.Person;
import org.springframework.social.google.api.plus.PlusOperations;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Service;

import com.odi.biz.user.UserVO;

@Service
public class GoogleService {

	private static final String GOOGLE_REVOKE_URL = "https://accounts.google.com/o/oauth2/revoke?token=";

	@Autowired
	private GoogleConnectionFactory googleConnectionFactory;

	@Autowired
	private OAuth2Parameters googleOAuth2Parameters;

	public String getLoginUrl() {
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();

		return oauthOperations.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);
	}

	public UserVO createUser(String code) {
		OAuth2Operations oauthOperations = googleConnectionFactory.getOAuthOperations();
		AccessGrant accessGrant = oauthOperations.exchangeForAccess(code, googleOAuth2Parameters.getRedirectUri(),
				null);
		String accessToken = accessGrant.getAccessToken();
		Long expireTime = accessGrant.getExpireTime();
		if (expireTime != null && expireTime < System.currentTimeMillis()) {
			accessToken = accessGrant.getRefreshToken();
		}
		
		Person person = requestPerson(accessGrant, accessToken);
		
		//System.out.println(person.toString());

		closeToken(accessToken);
		
		return personToUser(person);
	}
	
	private Person requestPerson(AccessGrant accessGrant, String accessToken) {
		Connection<Google> connection = googleConnectionFactory.createConnection(accessGrant);
		Google google = connection == null ? new GoogleTemplate(accessToken) : connection.getApi();
		PlusOperations plusOperations = google.plusOperations();
		
		return plusOperations.getGoogleProfile();
	}

	private void closeToken(String accessToken) {
		try { 
			URL url = new URL(GOOGLE_REVOKE_URL + accessToken);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setDoOutput(true);

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private UserVO personToUser(Person person) {
		return new UserVO.Builder()
				.id(nullToEmpty(person.getId()))
				.email(nullToEmpty(person.getAccountEmail()))
				.nickname(nullToEmpty(person.getDisplayName()))
				.loginType(UserVO.LoginType.Google.name())
				.build();
	}	
}
