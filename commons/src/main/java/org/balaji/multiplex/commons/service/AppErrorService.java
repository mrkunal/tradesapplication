package org.balaji.multiplex.commons.service;

import org.balaji.multiplex.commons.util.constants.AppErrorCode;
import org.balaji.multiplex.commons.util.dto.DataError;

public interface AppErrorService {
	DataError createDataError(AppErrorCode errorCode, String errorInfo);
}
