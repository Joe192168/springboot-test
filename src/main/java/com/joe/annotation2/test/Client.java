package com.joe.annotation2.test;

import com.joe.annotation2.config.AppConfig;
import com.joe.annotation2.dao.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Client {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = (UserService) annotationConfigApplicationContext.getBean("userServiceImpl");
		userService.insert();
	}
}