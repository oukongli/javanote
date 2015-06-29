package demo.adapter;

/**
 * Created by kouyang on 6/4/2015.
 */
public class Wrapper implements Targetable {
    private Source source;

    public Wrapper(Source source) {
        this.source = source;
    }

    public void method1() {
        source.method1();
    }

    public void method2() {
        System.out.println("targetable method");
    }
}
