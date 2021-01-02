package org.balaji.multiplex.commons.config;/*package org.balaji.multiplex.commons.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.balaji.multiplex.commons.domain.Roles;
import org.balaji.multiplex.commons.model.CustomUserDetails;
import org.balaji.multiplex.commons.repositories.OAuthHashRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

//@Component
public class AuthTokenFilter extends OncePerRequestFilter {

	// @Autowired
	private AppAuthenticationManager appAuthenticationManager;
	
	// @Autowired
	private OAuthHashRedisRepository oAuthHashRedisRepository;

	private static final Logger log = LogManager.getLogger(AuthTokenFilter.class);

	
	 * @Override public void init(FilterConfig cf) throws ServletException {
	 * super(cf); oAuthHashRedisRepository = WebApplicationContextUtils.
	 * getRequiredWebApplicationContext(getServletContext()).
	 * getBean(OAuthHashRedisRepository.class); }
	 



	// @Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// init();
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String authToken = httpRequest.getHeader("X-TOKEN-AUTH");
		String username = null;

		CustomUserDetails userDetails = new CustomUserDetails();
		userDetails.setEmail("blah@blahh.com");
		userDetails.setRoles(new HashSet<Roles>(Arrays.asList(Roles.ROLE_OBS_ADMIN)));
		userDetails.setPassword("$2a$10$ewY7UYlIAojvyK.tvMJAKOtSfkgKw8VU4Fl6whE6Yid6/fhBRoy2.");
		userDetails.setUserId("2173");

		if (authToken != null) {

			// CustomUserDetails userDetailsNew = oAuthHashRedisRepository.get(authToken);

			UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(userDetails,
					userDetails.getPassword(), userDetails.getAuthorities());
			// authReq.setAuthenticated(true);
			Authentication auth = authReq; // authManager.authenticate(authReq);

			SecurityContext sc = SecurityContextHolder.getContext();
			sc.setAuthentication(auth);
			HttpSession session = request.getSession(true);

			log.info("Inside Called of token");

		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			
			 * UserDetails userDetails = userDetailsService.loadUserByUsername(username); //
			 * // TODO: validate token UsernamePasswordAuthenticationToken authentication =
			 * new UsernamePasswordAuthenticationToken(userDetails, null,
			 * userDetails.getAuthorities()); authentication.setDetails(new
			 * WebAuthenticationDetailsSource().buildDetails(httpRequest));
			 * SecurityContextHolder.getContext().setAuthentication(authentication);
			 

			log.info("Inside out Called of token");
		}
		log.info("1");

		chain.doFilter(request, response);
		log.info("2");
	}
}
*/