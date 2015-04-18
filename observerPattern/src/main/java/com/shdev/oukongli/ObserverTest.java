package com.shdev.oukongli;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by kouyang on 4/17/2015.
 */
public class ObserverTest implements Observer {

    public ObserverTest(Observable observable) {
        observable.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        String str = "username: --> %1$s";
        System.out.println(String.format(str, ((User)o).getUsername()));
    }
}
