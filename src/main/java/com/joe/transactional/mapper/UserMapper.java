package com.joe.transactional.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.joe.transactional.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    void insertUser(List<User> list);

    void updateUser(User user);
}
