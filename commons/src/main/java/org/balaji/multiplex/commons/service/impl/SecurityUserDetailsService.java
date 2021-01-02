package org.balaji.multiplex.commons.service.impl;

import org.balaji.multiplex.commons.domain.Roles;
import org.balaji.multiplex.commons.model.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@PostConstruct
	public void postConstructCalled() {
		System.out.println("## Commons APi Called SecurityUserDetailsService");
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		/*
		 *
		 * ObjectId ob=new ObjectId("5c625a52ca79963d504733a1");
		 * System.out.println("ob called"); Optional<Users> user =
		 * userRepository.findById(ob);
		 * 
		 * System.out.println("ob called2");
		 * 
		 * user.orElseThrow(() -> new UsernameNotFoundException("Username Not Found"));
		 */
		
		System.out.println("blah called3");
		
		CustomUserDetails userDetails = new CustomUserDetails();
		userDetails.setEmail("balh@blah.com");
		userDetails.setRoles(new HashSet<Roles>(Arrays.asList(Roles.ROLE_OBS_ADMIN)));
		userDetails.setPassword("$2a$10$ewY7UY73lIAojvyK.tvMJAKOtSfkgKw8VU4Fl6whE6Yid6/fhBRoy2.");
		userDetails.setUserId(2173);

		System.out.println("User Details :"+userDetails.getAuthorities());

		return userDetails;
	}
}
