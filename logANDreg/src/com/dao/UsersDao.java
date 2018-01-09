package com.dao;

import java.util.List;

import com.model.Users;

public interface UsersDao {
	public int addUsers(Users users);
	public List<Users>  selectUsers(Users users);
}
