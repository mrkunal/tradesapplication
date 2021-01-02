package org.balaji.multiplex.commons.service.impl;

import org.balaji.multiplex.commons.service.AppErrorService;
import org.balaji.multiplex.commons.util.constants.AppErrorCode;
import org.balaji.multiplex.commons.util.constants.AppErrorConstant;
import org.balaji.multiplex.commons.util.dto.DataError;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Service
public class AppErrorServiceImpl implements AppErrorService {

	private HashMap<AppErrorCode, String> map;

	@PostConstruct
	private void initialize() {
		if (map == null) {
			map = new LinkedHashMap();
			map.put(AppErrorCode.INVALID_URL_PARAMETER_VALUE, AppErrorConstant.INVALID_URL_PARAMETER_VALUE_MSG);
			map.put(AppErrorCode.MISSING_BODY, AppErrorConstant.MISSING_BODY_MSG);
			map.put(AppErrorCode.INVALID_BODY, AppErrorConstant.INVALID_BODY_MSG);
			map.put(AppErrorCode.MISSING_BODY_FIELD, AppErrorConstant.MISSING_BODY_FIELD_MSG);
			map.put(AppErrorCode.INVALID_BODY_FIELD, AppErrorConstant.INVALID_BODY_FIELD_MSG);
			map.put(AppErrorCode.MISSING_HEADER, AppErrorConstant.MISSING_HEADER_MSG);
			map.put(AppErrorCode.INVALID_HEADER_VALUE, AppErrorConstant.INVALID_HEADER_VALUE_MSG);
			map.put(AppErrorCode.MISSING_QUERY_STRING_PARAMETER, AppErrorConstant.MISSING_QUERY_STRING_PARAMETER_MSG);
			map.put(AppErrorCode.INVALID_QUERY_STRING_PARAMETER, AppErrorConstant.INVALID_QUERY_STRING_PARAMETER_MSG);
			map.put(AppErrorCode.INTERNAL_ERROR, AppErrorConstant.INTERNAL_ERROR_MSG);
			map.put(AppErrorCode.DUPLICATE_REQUEST, AppErrorConstant.DUPLICATE_REQUEST);
			
		}
	}

	private String getErrorMessage(AppErrorCode errorCode) {
		return map.get(errorCode);
	}

	@Override
	public DataError createDataError(AppErrorCode errorCode, String errorInfo) {
		return new DataError(errorCode.getName(), getErrorMessage(errorCode), errorInfo);
	}

}
