package com.shdev.oukongli.test;

import com.shdev.oukongli.dao.DAOFactory;
import com.shdev.oukongli.dao.IUserDao;
import com.shdev.oukongli.model.User;


/**
 * Created by ou_kongli on 2015/4/21.
 */
public class Init {
    public static void main(String[] args) {
        IUserDao userDao = DAOFactory.getUserDao();
        for (int i = 1; i <= 1000; i++) {
            String username = "username" + i;
            String password = "password";
            String nickname = "nickname";
            User u = new User(username, password, nickname);
            userDao.add(u);
        }
    }
}
