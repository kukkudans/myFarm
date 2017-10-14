package com.farm.rest.conf;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomFilter.class);

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		String origin = StringUtils.isEmpty(request.getHeader("origin")) ? "*" : request.getHeader("origin");
		response.setHeader("Access-Control-Allow-Origin", origin);
		response.setHeader("Access-Control-Allow-Methods", "PUT,POST,GET,OPTIONS,DELETE,HEAD");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "X-CSRF-TOKEN,X-CSRF-HEADER,Origin,Methods,Accept,X-Requested-With,X-HTTP-Method-Override,Content-Type,Authorization");
		response.setHeader("Access-Control-Expose-Headers", "X-CSRF-TOKEN,X-CSRF-HEADER,Origin,Methods,Accept,X-Requested-With,X-HTTP-Method-Override,Content-Type,Authorization");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		String requestURI = request.getRequestURI();
//		if (!requestURI.endsWith( ".jar")) {
//			// Set default cache control options we disabled in WebSecurityConfig for non-jar files
//			// http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#headers-cache-control
//			response.setHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
//			response.setHeader("Pragma", "no-cache");
//			response.setHeader("Expires", "0");
//		}

		if (LOGGER.isTraceEnabled()) {
			LocalDateTime lastAccessTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(request.getSession().getLastAccessedTime()), TimeZone.getDefault().toZoneId());
			int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
			LOGGER.trace("Last access time: {}, max intactive interval: {}", lastAccessTime, maxInactiveInterval);
		}
		
		chain.doFilter(req, res);
	}

	public void init(FilterConfig filterConfig) {}

	public void destroy() {}

}