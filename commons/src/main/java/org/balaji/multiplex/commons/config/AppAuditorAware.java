package org.balaji.multiplex.commons.config;

import org.balaji.multiplex.commons.model.CustomUserDetails;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**

 *
 */
@Configuration
public class AppAuditorAware implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || !authentication.isAuthenticated()) {
			return Optional.of(null);
		}
		CustomUserDetails user = ((CustomUserDetails) authentication.getPrincipal());
		return Optional.of(user.getUsername());
	}
}
