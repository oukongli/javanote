package com.oukongli.dao;

import com.oukongli.model.User;

/**
 * Created by ou_kongli on 2015/5/5.
 */
public interface IUserDao {
    public User load(int userId);
}
