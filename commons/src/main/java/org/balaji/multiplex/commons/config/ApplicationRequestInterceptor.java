package org.balaji.multiplex.commons.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

//import org.apache.commons.lang.StringUtils;

@Component
public class ApplicationRequestInterceptor implements HandlerInterceptor {

	private static final Logger log = LogManager.getLogger(ApplicationRequestInterceptor.class);
	
	private static final String CORRELATION_ID_HEADER_NAME = "CORRELATION_TOKEN";

	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

		
		String correlationId = getCorrelationIdFromHeader(request);
		ThreadContext.put(CORRELATION_ID_HEADER_NAME, correlationId);
		response.addHeader(CORRELATION_ID_HEADER_NAME, correlationId);	
		log.trace("PreHandler Called");
		return true; 
	}

	private String getCorrelationIdFromHeader(final HttpServletRequest request) {
		String correlationId = request.getHeader(CORRELATION_ID_HEADER_NAME);
		if (StringUtils.isEmpty(correlationId)) {
			correlationId = generateUniqueCorrelationId();
		}
		return correlationId;
	}

	private String generateUniqueCorrelationId() {
		return UUID.randomUUID().toString();
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		log.trace("postHandler Called");
	}
	
	

}
