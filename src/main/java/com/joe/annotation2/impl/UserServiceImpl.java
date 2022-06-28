package com.joe.annotation2.impl;

import com.joe.annotation2.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserService userDao;
 
	@Override
	public void insert() {
		userDao.insert();
	}
 
}