package org.balaji.multiplex.commons.domain;

import org.balaji.multiplex.commons.service.impl.CustomRoleHierachyImpl;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public enum Roles {

	ROLE_VENDOR_USER("VENDOR_USER"), ROLE_OBS_USER("OBS_USER"),
	ROLE_ANY_USER("USER", ROLE_OBS_USER, ROLE_VENDOR_USER),
	ROLE_OBS_ADMIN("OBS_ADMIN", ROLE_OBS_USER),
	ROLE_VENDOR_ADMIN("VENDOR_ADMIN", ROLE_VENDOR_USER),
	ROLE_USER_ADMIN("USER_ADMIN", ROLE_OBS_ADMIN, ROLE_VENDOR_ADMIN, ROLE_ANY_USER),
	ROLE_SUPER_ADMIN("SUPER_ADMIN", ROLE_USER_ADMIN);

	private Roles[] includings;
	public final String shortName;

	Roles(String shortName, Roles... includings) {
		this.includings = includings;
		this.shortName = shortName;
	}

	public Roles[] getIncludings() {
		return includings;
	}

	public Set<String> getAllRoles() {

		Set<String> rolesSet = new HashSet<>();
		Arrays.asList(this.getIncludings()).stream()
				.forEach(role -> role.getAllRoles().forEach(roleValue -> rolesSet.add(roleValue)));

		rolesSet.add(shortName);

		return rolesSet;
	}

	public boolean hasIncludings() {
		return includings != null && includings.length > 0;
	}

	public String getShortName() {
		return shortName;
	}

	public String role() {
		return this.name();
	}

	public static RoleHierarchy resolveToRoleHierachy() {
		CustomRoleHierachyImpl roleHierarchy = new CustomRoleHierachyImpl();
		String currentHierachy = "";
		// iterate over all defined system roles ...
		for (Roles systemRole : Roles.values()) {

			if (systemRole.hasIncludings()) {
				// iterate over all includings
				for (Roles includedRole : systemRole.getIncludings()) {
					roleHierarchy.addRoleHierarchy(systemRole.role() + " > " + includedRole.role());
				}
			}
		}
		return roleHierarchy;
	}
}
