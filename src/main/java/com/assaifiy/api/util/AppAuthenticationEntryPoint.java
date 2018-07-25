package com.assaifiy.api.util;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AppAuthenticationEntryPoint extends BasicAuthenticationEntryPoint{
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException{
		response.addHeader("WWW-Authenticate", "Basic realm="+getRealmName());
		response.setStatus(Integer.valueOf(""+HttpStatus.UNAUTHORIZED));
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,authException.getMessage());
	}
	
	@Override
	public void afterPropertiesSet() throws Exception{
		setRealmName("ASSAIFIY API");
	}
}
