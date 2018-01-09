package com.service;

import java.util.List;

import com.model.Users;

public interface UsersService {
	public int addUsers(Users users);
	public List<Users>  selectUsers(Users users);

}
