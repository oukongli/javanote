package com.shdev.demo.dao;

import com.shdev.demo.mapper.UserMapper;
import com.shdev.demo.model.User;

import java.util.List;

public class UserDaoImpl implements IUserDao {

    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User login(User user) {
        return userMapper.login(user);
    }

    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    public void addUser(String userName) {
        userMapper.addUser(userName);
    }

    public void deleteUser(String userName) {
        userMapper.deleteUser(userName);
    }

    public void deleteAll() {
        userMapper.deleteAll();
    }
}
