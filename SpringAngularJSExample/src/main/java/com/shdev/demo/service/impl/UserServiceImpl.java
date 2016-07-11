package com.shdev.demo.service.impl;


import javax.annotation.Resource;

import com.shdev.demo.dao.UserDao;
import com.shdev.demo.model.User;
import com.shdev.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    //public List<User> userList = getAllUsers();

    @Resource
    private UserDao userDao;

    public User login(User user) {
        return userDao.login(user);
    }

    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void addUser(String userName) {
        userDao.addUser(userName);
    }

    public void deleteUser(String userName) {
        userDao.deleteUser(userName);
    }

    public void deleteAll() {
        userDao.deleteAll();
    }

}
