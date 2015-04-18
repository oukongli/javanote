package com.shdev.oukongli;

/**
 * Created by kouyang on 4/17/2015.
 */
public class App {
    public static void main(String[] args) {
        User user = new User("111");
        ObserverTest observerTest = new ObserverTest(user);
        user.addObserver(observerTest);
        System.out.println(user.getUsername());
        user.setUsername("222");
        user.setUsername("333");
        user.setUsername("444");
        user.setUsername("555");
    }
}
