package model;

/**
 * Created by ou_kongli on 2015/5/14.
 */
public class User {
    private String username;
    private String nickname;
    private int age;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User(String username, String nickname, int age) {

        this.username = username;
        this.nickname = nickname;
        this.age = age;
    }
}
