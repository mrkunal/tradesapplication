package org.balaji.multiplex.commons.config;

import org.balaji.multiplex.commons.config.TokenBasedAuthorizationFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.balaji.multiplex.commons.repositories.OAuthHashRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final Logger log = LogManager.getLogger(SpringSecurityConfiguration.class);
	@Autowired
	private DefaultWebSecurityExpressionHandler securityExpressionHandler;

/*  
  @Autowired
	private AppAuthenticationManager appAuthenticationManager;
*/
	@Autowired
	private OAuthHashRedisRepository oAuthHashRedisRepository;
	
	private UserDetailsService securityUserDetailsService;
	private PasswordEncoder passwordEncoder;

	/**
	 * @param securityUserDetailsService
	 * @param passwordEncoder
	 */
	public SpringSecurityConfiguration(UserDetailsService securityUserDetailsService, PasswordEncoder passwordEncoder) {
		super();
		this.securityUserDetailsService = securityUserDetailsService;
		this.passwordEncoder = passwordEncoder;
	}

	

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().expressionHandler(securityExpressionHandler)
				.anyRequest()
				.authenticated()
				.and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().httpBasic().and().csrf().disable();

		http.addFilterBefore(new TokenBasedAuthorizationFilter(authenticationManager(), oAuthHashRedisRepository),
				UsernamePasswordAuthenticationFilter.class);

	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**","/public/*");
	}
	
	@Bean
	protected RoleVoter roleVoter(RoleHierarchy roleHierarchy) {
		return new RoleHierarchyVoter(roleHierarchy);
	}

	@Bean
	protected DefaultWebSecurityExpressionHandler webExpressionHandler(RoleHierarchy roleHierarchy) {
		DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
		defaultWebSecurityExpressionHandler.setRoleHierarchy(roleHierarchy);
		return defaultWebSecurityExpressionHandler;
	}

}
