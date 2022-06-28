package com.joe.autowired.impl;

import com.joe.autowired.dao.UserDao;
import com.joe.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void insert() {
        userDao.insert();
        System.out.println("调用：insert()");
    }

}