package org.balaji.multiplex.commons.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersPasswordEncoder implements PasswordEncoder {

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UsersPasswordEncoder() {
		super();
		this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public String encode(CharSequence charSequence) {
		return bCryptPasswordEncoder.encode(charSequence);
	}

	@Override
	public boolean matches(CharSequence charSequence, String encodedPassword) {
		return bCryptPasswordEncoder.matches(charSequence, encodedPassword);
	}
}
