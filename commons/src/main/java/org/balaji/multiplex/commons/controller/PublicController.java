package org.balaji.multiplex.commons.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.balaji.multiplex.commons.domain.Roles;
import org.balaji.multiplex.commons.model.CustomUserDetails;
import org.balaji.multiplex.commons.repositories.OAuthHashRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;

@RestController
@RequestMapping("/public")
public class PublicController {

	private final Logger logger = LogManager.getLogger(PublicController.class);
	
	@Autowired
	private OAuthHashRedisRepository oAuthHashRedisRepository;

	@GetMapping("/insertOAuthToken")
	public String insertOAuthToken() {
		logger.info("Insert OAuth Token started");

		CustomUserDetails userDetails = new CustomUserDetails();
		userDetails.setEmail("blahhbalh@blah.com");
		userDetails.setRoles(new HashSet<Roles>(Arrays.asList(Roles.ROLE_TRADES_ADMIN)));
		userDetails.setPassword("$2a$10$ewY7UYlIAojvyK.tvMJAKOtSfkgKw8VU4Fl6whE6Yid6/fhBRoy2.");
		userDetails.setUserId(2173);

		oAuthHashRedisRepository.put("K2", userDetails);

		return "Inserted successfully";
	}

	@GetMapping("/test")
	public ResponseEntity<String> test(){
		System.out.println("test called");
		return ResponseEntity.ok("passed");
	}



}
