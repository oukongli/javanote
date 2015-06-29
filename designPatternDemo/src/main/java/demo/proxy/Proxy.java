package demo.proxy;

/**
 * Created by kouyang on 6/4/2015.
 */
public class Proxy implements Sourceable {
    private Source source;

    public Proxy() {
        this.source = new Source();
    }

    public void method() {
        before();
        source.method();
        after();
    }

    private void before() {

    }

    private void after() {

    }


}
