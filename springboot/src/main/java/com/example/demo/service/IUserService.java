package com.example.demo.service;

import com.example.demo.model.user;

import java.util.List;

/**
 * 用户service层
 */
public interface IUserService {

    void addNewUser(String userName, String password);

    List<user> findUsersByCondition(int id, String userName);

    user findUserById(int id);

    void update(int id, String userName, String password);

    void delete(int id);
}
