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
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(RequestUserInterceptor()).addPathPatterns("/assaifiy/v1/admin/*");
	}
}
