package org.balaji.multiplex.commons.handlers;


import lombok.Data;
import org.balaji.multiplex.commons.util.constants.AppErrorCode;

@Data
public class BaseApplicationException extends Exception {
	private AppErrorCode errorCode;
	private String errorInfo;

	public BaseApplicationException() {
		super();
	}

	public BaseApplicationException(AppErrorCode appErrorCode, String errorInfo) {
		super();
		this.errorCode = appErrorCode;
		this.errorInfo = errorInfo;

	}
}
