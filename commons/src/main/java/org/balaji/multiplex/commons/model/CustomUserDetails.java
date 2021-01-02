package org.balaji.multiplex.commons.model;

import lombok.Data;
import lombok.ToString;
import org.balaji.multiplex.commons.domain.BaseEntity;
import org.balaji.multiplex.commons.domain.Roles;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString(callSuper = true)
public class CustomUserDetails extends BaseEntity implements UserDetails, Serializable {

	private Integer userId;
	private String username;
	private String email;
	private String fullName;
	private Set<Roles> roles;
	private String password;

	public CustomUserDetails() {

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> rolesSet = new HashSet<>();

		getRoles().stream().forEach(role -> {
			role.getAllRoles().forEach(r -> rolesSet.add(new SimpleGrantedAuthority("ROLE_" + r)));
		});

		rolesSet.forEach(System.out::println);

		return rolesSet;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
