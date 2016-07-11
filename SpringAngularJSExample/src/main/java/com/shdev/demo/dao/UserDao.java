package com.shdev.demo.dao;

import com.shdev.demo.model.User;

import java.util.List;


public interface UserDao {

    public User login(User user);

    public User getUserById(int id);

    public List<User> getAllUsers();

    public void addUser(String userName);

    public void deleteUser(String userName);

    public void deleteAll();
}
