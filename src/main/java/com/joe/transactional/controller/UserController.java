package com.joe.transactional.controller;

import com.joe.transactional.pojo.User;
import com.joe.transactional.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/updateById")
    public String updateByUser(
            @RequestParam Integer id,
            @RequestParam String userName,
            @RequestParam String password,
            @RequestParam Integer age){
        try {
            User user = new User();
            user.setId(id);
            user.setUserName(userName);
            user.setPassword(password);
            user.setAge(age);
            userService.updateById(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error："+e.getStackTrace();
        }
        return "ok";
    }

}
