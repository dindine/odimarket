package com.odi.utils;

import java.math.BigInteger;
import java.security.SecureRandom;

//세션 유지 및 위조 방지용 토큰 생성
public class Utils {
	public static String generateState() {
		SecureRandom random = new SecureRandom();
		return new BigInteger(130, random).toString(32);
	}
}
