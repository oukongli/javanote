package com.shdev.demo.service.impl;


import com.shdev.demo.dao.IUserDao;
import com.shdev.demo.model.User;
import com.shdev.demo.service.UserService;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;


public class UserServiceImpl implements UserService {
    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    @Required
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

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
