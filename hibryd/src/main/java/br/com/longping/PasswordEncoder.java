package br.com.longping;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	private static void main(String [] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode("123"));
	}
}
