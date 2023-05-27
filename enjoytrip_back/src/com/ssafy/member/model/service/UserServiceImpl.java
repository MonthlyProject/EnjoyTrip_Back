package com.ssafy.member.model.service;

import com.ssafy.user.model.UserDto;
import com.ssafy.user.model.dao.UserDao;
import com.ssafy.user.model.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

	private static UserService instance;
	private UserDao userDao;
	
	private UserServiceImpl() {
		userDao = UserDaoImpl.getInstance();
	}
	
	public static UserService getInstance() {
		if(instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}
	
	@Override
	public int signUp(UserDto user) throws Exception {
		return userDao.signUp(user);
	}

	@Override
	public UserDto signIn(UserDto user) throws Exception {
		return userDao.signIn(user);
	}

}
