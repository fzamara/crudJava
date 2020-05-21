package br.com.longping.Config;

import java.util.concurrent.TimeUnit;

public class SecurityConstants {

	 final static String SECRET = "zamara";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_STRING = "Authorization";
	static final String SIGN_UP_URL = "/users/sign-up";
	final static long EXPIRATION_TIME = 86400000000L;

	public static void main(String[] args) {
		System.out.println(TimeUnit.MICROSECONDS.convert(1, TimeUnit.DAYS));
	}

}
