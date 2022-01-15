package org.balaji.multiplex.commons.util.enums;

public enum Role {

	SUPER_ADMIN("SUPER_ADMIN"), USER_ADMIN("USER"), USER("USER"), TRADES_USER("TRADES_USER"), VENDOR_USER("VENDOR_USER"),
	TRADES_ADMIN("TRADES_ADMIN"), VENDOR_ADMIN("VENDOR_ADMIN");

	private String name;

	Role(String name) {
		this.name = name;
	}
}
