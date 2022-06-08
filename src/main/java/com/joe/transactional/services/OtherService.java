package com.joe.transactional.services;

import java.util.ArrayList;
import java.util.List;

import com.joe.transactional.mapper.UserMapper;
import com.joe.transactional.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OtherService  {

	@Autowired
	private UserMapper userMapper;

	//新增
	@Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean insertUser() {
    	List<User> list = new ArrayList<>();
    	for (int i = 10; i <15; i++) {
    	    User user = new User();
    		user.setId(i);
    		user.setUserName("*username" + i);
    		user.setPassword("*password*"+i);
    		user.setAge(i);
    		list.add(user);
        }
    	userMapper.insertUser(list);
        return true;
    }
}
