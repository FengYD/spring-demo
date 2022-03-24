package com.feng.demo.mysql.service;

import com.feng.demo.mysql.domain.User;
import com.feng.demo.mysql.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author fengyadong001
 * @date 2022/3/24 10:33 上午
 * @description
 */
@Service
public abstract class TestTransBase {

    @Resource
    private UserMapper userMapper;

    public void addUser(User user) {
        userMapper.insert(user);
    }

}