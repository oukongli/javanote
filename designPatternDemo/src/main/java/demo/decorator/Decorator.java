package demo.decorator;

/**
 * Created by kouyang on 6/4/2015.
 */
public class Decorator implements Sourceable{
    private Sourceable source;

    public Decorator(Sourceable source) {
        this.source = source;
    }

    public void method() {
        System.out.println("before decorator!");
        source.method();
        System.out.println("after decorator!");
    }
}
