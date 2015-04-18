package com.shdev.oukongli;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by kouyang on 4/17/2015.
 */
public class User extends Observable{
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (!this.username.equals(username)) {
            this.username = username;
            setChanged();
        }
        notifyObservers();
    }
}
