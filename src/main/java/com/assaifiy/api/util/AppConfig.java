package com.assaifiy.api.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

	@Bean
	public RequestUserInterceptor RequestUserInterceptor() {
	    return new RequestUserInterceptor();
	}
	@Bean
	public RequestAdminInterceptor RequestAdminInterceptor() {
	    return new RequestAdminInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(RequestAdminInterceptor()).addPathPatterns("/assaifiy/v1/admin/*");
		registry.addInterceptor(RequestUserInterceptor()).addPathPatterns("/assaifiy/v1/*");

	}
}
