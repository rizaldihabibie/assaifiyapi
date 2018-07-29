package com.assaifiy.api.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.assaifiy.api.model.LogActivity;
import com.assaifiy.api.service.LogActivityService;

public class RequestUserInterceptor implements HandlerInterceptor {

	@Autowired
	private LogActivityService logActivityService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		try{
		LogActivity log = new LogActivity();
		log.setUsername(request.getRemoteUser());
		log.setLogIpAddress(request.getRemoteAddr());
		log.setLogRequestedUrl(request.getRequestURI());
		logActivityService.save(log);
		}catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
}
