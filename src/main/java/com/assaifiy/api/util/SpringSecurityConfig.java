package com.assaifiy.api.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.assaifiy.api.service.impl.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private AuthenticationEntryPoint authEntryPoint;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests()
		.antMatchers("/assaifiy/**").authenticated()
		.and().httpBasic()
		.authenticationEntryPoint(authEntryPoint);
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication().withUser("john123").password("$2a$04$AjFEmZeX7mN8zSn57PUEZeJgBeoKMvwteZMBiP57Jb4AGFsUORmLC").roles("USER");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}
}
