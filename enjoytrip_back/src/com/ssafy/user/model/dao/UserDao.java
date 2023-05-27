package com.ssafy.user.model.dao;

import java.sql.SQLException;

import com.ssafy.user.model.UserDto;

public interface UserDao {
	public int signUp(UserDto user) throws SQLException;
	public UserDto signIn(UserDto user) throws SQLException;
}
