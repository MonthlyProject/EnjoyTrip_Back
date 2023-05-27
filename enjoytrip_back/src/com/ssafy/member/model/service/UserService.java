package com.ssafy.member.model.service;

import com.ssafy.user.model.UserDto;

public interface UserService {
	public int signUp(UserDto user) throws Exception;
	public UserDto signIn(UserDto user) throws Exception;
//	public int idCheck(userDto user) throws Exception;

}
