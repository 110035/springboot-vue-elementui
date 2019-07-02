package com.example.demo.service.impl;

import com.example.demo.model.user;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户Service层实现
 */
@Service()
public class userService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addNewUser(String userName, String password) {
        userMapper.addNewUser(userName,password);
    }

    @Override
    public List<user> findUsersByCondition(int id, String userName) {
        List<user> userList = userMapper.findUsersByCondition(id,userName);
        return userList;
    }

    @Override
    public user findUserById(int id) {
        user user = userMapper.findUserById(id);
        return user;
    }

    @Override
    public void update(int id, String userName, String password) {
        userMapper.update(id, userName, password);
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }


}
