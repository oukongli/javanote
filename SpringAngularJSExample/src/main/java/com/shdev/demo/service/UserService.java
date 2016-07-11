package com.shdev.demo.service;


import com.shdev.demo.model.User;

import java.util.List;

public interface UserService {

    public User login(User user);

    public User getUserById(int id);

    public List<User> getAllUsers();

    public void addUser(String userName);

    public void deleteUser(String userName);

    public void deleteAll();
}
