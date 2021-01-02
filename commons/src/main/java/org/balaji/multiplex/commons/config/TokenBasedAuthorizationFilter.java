package org.balaji.multiplex.commons.config;

import org.balaji.multiplex.commons.domain.Roles;
import org.balaji.multiplex.commons.model.CustomUserDetails;
import org.balaji.multiplex.commons.repositories.OAuthHashRedisRepository;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

public class TokenBasedAuthorizationFilter extends BasicAuthenticationFilter {

	private OAuthHashRedisRepository oAuthHashRedisRepository;

	TokenBasedAuthorizationFilter(AuthenticationManager authenticationManager,
			OAuthHashRedisRepository oAuthHashRedisRepository) {
		super(authenticationManager);
		this.oAuthHashRedisRepository = oAuthHashRedisRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String authToken = httpRequest.getHeader("X-TOKEN-AUTH");
		String username = null;

		if (StringUtils.isEmpty(authToken)) {
//			throw new AuthenticationCredentialsNotFoundException("X-TOKEN-AUTH missing in the Header Request");
		}

		
		
		Optional<CustomUserDetails> user;  // = oAuthHashRedisRepository.get(authToken);

		CustomUserDetails userDetails = new CustomUserDetails();
		userDetails.setEmail("super.admin@balajimultiplex.com");
		userDetails.setRoles(new HashSet<Roles>(Arrays.asList(Roles.ROLE_SUPER_ADMIN)));
		userDetails.setPassword("$2a$10$ewY7UYlIAojvyK.tvMJAKOtSfkgKw8VU4Fl6whE6Yid6/fhBRoy2.");
		userDetails.setUserId(1);
		userDetails.setUsername("super_admin");
		user=Optional.of(userDetails);

		user.ifPresent(u->{
			Authentication auth=new UsernamePasswordAuthenticationToken(u,
					u.getPassword(), u.getAuthorities());
			SecurityContext sc = SecurityContextHolder.getContext();
			sc.setAuthentication(auth);
			
		});


		
		


//		UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(userDetails,
//				userDetails.getPassword(), userDetails.getAuthorities());
		// authReq.setAuthenticated(true);
//		Authentication auth = authReq; // authManager.authenticate(authReq);


		/*
		 * String authorizationToken = request.getHeader(HttpHeaders.AUTHORIZATION);
		 * 
		 * if (authorizationToken != null && authorizationToken.equals("success!")) {
		 * SecurityContextHolder.getContext() .setAuthentication(new
		 * UsernamePasswordAuthenticationToken("user", null, Collections.emptyList()));
		 * }
		 */
		chain.doFilter(request, response);
	}
	
	/*@Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getServletPath();
        return !path.startsWith("/public/*");
    }*/
}
