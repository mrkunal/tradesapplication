package org.balaji.multiplex.commons.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.balaji.multiplex.commons.repositories.OAuthHashRedisRepository;
import org.balaji.multiplex.commons.util.constants.RoleConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
//@PreAuthorize("hasRole('" + RoleConstants.OBS_ADMIN + "')")
//@PreAuthorize("permitAll()")
public class ApplicationTestController {

	private final Logger logger = LogManager.getLogger(ApplicationTestController.class);

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Autowired
	private OAuthHashRedisRepository oAuthHashRedisRepository;

	private static void writeHeader(final String headerText) {
		final String headerSeparator = "=".repeat(headerText.length() + 4);

		System.out.println("\n " + headerSeparator);
		System.out.println(headerText);
		System.out.println(headerSeparator);
	}

	@GetMapping("/test")
	public String test() {
		logger.info("hello World");
		String originalString = "Hello\nWorld\n123";

		String stringWithoutLineSeparators = originalString.replaceAll("\\n", "\\\\n");

		writeHeader("String.lines() on '" + stringWithoutLineSeparators + "'");

		originalString.lines().forEach(System.out::println);

		return "Hello World";
	}

	@GetMapping("/test3")
	public String test3() {
		logger.info("hello World");
		String originalString = "Hello\nWorld\n123";

		String stringWithoutLineSeparators = originalString.replaceAll("\\n", "\\\\n");

		writeHeader("String.lines() on '" + stringWithoutLineSeparators + "'");

		originalString.lines().forEach(System.out::println);

		return "Hello World3";
	}

	

	@GetMapping("/test2")
	public String test2() {
		logger.info("hello World");

		// RedisTemplate<String, String> redis = new RedisTemplate<>();
		// redisTemplate.opsForValue().set("t4", "k8");

		// HashOperations<String, String, Object> hops = redisTemplate.opsForHash();
		// hops.put("K1", "k2", "k3");

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()) {
			return null;
		}
		logger.info("{} ", authentication.getPrincipal().toString());

		// CustomUserDetails user = ((CustomUserDetails) authentication.getPrincipal());

		//logger.info("Userr {}", user.toString());
		return "Hello World";
	}
}
