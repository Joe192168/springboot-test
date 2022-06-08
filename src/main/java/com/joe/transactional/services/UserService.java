package com.joe.transactional.services;

import com.joe.transactional.mapper.UserMapper;
import com.joe.transactional.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private OtherService otherService;

	//更新
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean updateById(User user) {
    	userMapper.updateUser(user);
		otherService.insertUser();
    	if(true) {
    		throw new RuntimeException("updateUserById 抛异常了");
    	}
        return true;
    }
    
    //新增
    public boolean insertUser() {
    	List<User> list = new ArrayList<>();
    	for (int i = 0; i <3; i++) {
    	    User user = new User();
    		user.setUserName("*username"+i);
    		user.setPassword("*password*"+i);
    		user.setAge(i);
    		list.add(user);
        }
    	userMapper.insertUser(list);
        return true;
    }
}
