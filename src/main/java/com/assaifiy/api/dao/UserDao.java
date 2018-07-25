package com.assaifiy.api.dao;

import com.assaifiy.api.model.UserModel;

public interface UserDao {

	public UserModel findByUsername(String username);
}
