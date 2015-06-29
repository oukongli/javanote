package demo.proxy;

/**
 * Created by kouyang on 6/4/2015.
 */
public class Source implements Sourceable {
    public void method() {
        System.out.println("proxy source method");
    }
}
