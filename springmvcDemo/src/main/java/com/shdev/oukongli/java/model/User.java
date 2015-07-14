package com.shdev.oukongli.java.model;

/**
 * Created by ou_kongli on 2015/7/14.
 */
public class User {
    private int id;
    private String name;
    private String nickname;

    public User() {
    }

    public User(int id, String name, String nickname) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
