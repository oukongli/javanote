package com.shdev.demo.mapper;

import com.shdev.demo.model.User;

import java.util.List;

public interface UserMapper {
    User login(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    void addUser(String userName);

    void deleteUser(String userName);

    void deleteAll();
}
