package com.assaifiy.api.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.assaifiy.api.dao.UserDao;
import com.assaifiy.api.model.UserModel;
import org.springframework.security.core.userdetails.User;

@Service("userService")
public class UserServiceImpl implements UserDetailsService {
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = userDao.findByUsername(username);
		GrantedAuthority authority = new SimpleGrantedAuthority(user.getUserPriviledge());
		UserDetails userDetails = (UserDetails) new User(user.getUserEmail(),user.getUserPassword(),Arrays.asList(authority));
		return userDetails;
	}

	
}
