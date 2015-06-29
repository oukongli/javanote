package demo.decorator;

/**
 * Created by kouyang on 6/4/2015.
 */
public class Source implements Sourceable {
    public void method() {
        System.out.println("decorator original method!");
    }
}
