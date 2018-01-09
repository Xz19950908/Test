package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UsersDao;
import com.model.Users;
import com.service.UsersService;
@Service
public class UserServiceImpl  implements UsersService{
	@Autowired
	private UsersDao usersDao;
	
	public UserServiceImpl(){
		System.out.println("UserServiceImpl=========");
	}

	@Override
	public int addUsers(Users users) {
		int result = usersDao.addUsers(users);
		return result;
	}

}
