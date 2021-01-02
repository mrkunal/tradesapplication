package org.balaji.multiplex.commons.util.constants;

public enum AppErrorCode {

	/* Application Error codes */

	INTERNAL_ERROR("ER-01"), INVALID_URL_PARAMETER_VALUE("ER-20"), MISSING_BODY("ER-21"), INVALID_BODY("ER-22"), MISSING_BODY_FIELD("ER-23"),
	INVALID_BODY_FIELD("ER-24"), MISSING_HEADER("ER-25"), INVALID_HEADER_VALUE("ER-26"), MISSING_QUERY_STRING_PARAMETER("ER-27"),
	INVALID_QUERY_STRING_PARAMETER("ER-28"), DUPLICATE_REQUEST("AER-01");

	private final String name;

	private AppErrorCode(String s) {
		name = s;
	}

	public String getName() {
		return name;
	}

}
