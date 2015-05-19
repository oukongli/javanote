package com.oukongli.dao;

import com.oukongli.model.Pager;
import com.oukongli.model.User;

import java.util.List;

/**
 * Created by ou_kongli on 2015/5/5.
 */
public interface IUserDao {
    public User load(int userId);
    public void add(User user);
    public void update(User user);
    public Pager<User> find(String name);
    public void delete(int id);
}
