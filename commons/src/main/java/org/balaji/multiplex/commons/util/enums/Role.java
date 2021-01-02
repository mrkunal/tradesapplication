package org.balaji.multiplex.commons.util.enums;

public enum Role {

	SUPER_ADMIN("SUPER_ADMIN"), USER_ADMIN("USER"), USER("USER"), OBS_USER("OBS_USER"), VENDOR_USER("VENDOR_USER"),
	OBS_ADMIN("OBS_ADMIN"), VENDOR_ADMIN("VENDOR_ADMIN");

	private String name;

	Role(String name) {
		this.name = name;
	}
}
