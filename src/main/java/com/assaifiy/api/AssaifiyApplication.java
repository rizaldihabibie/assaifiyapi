package com.assaifiy.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages="com.assaifiy.api")
@SpringBootApplication
public class AssaifiyApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(AssaifiyApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(AssaifiyApplication.class, args);
	}
}
