package com.shdev.oukongli.dao;

import com.shdev.oukongli.model.Pager;
import com.shdev.oukongli.model.User;

import java.util.List;

/**
 * Created by ou_kongli on 2015/4/16.
 */
public interface IUserDao {
    public void add(User user);
    public void delete(int id);
    public void update(User user);
    public User load(int id);
    public Pager<User> list(String conf, int pageSize, int pageIndex);
    public User login(String username, String password);
}
