package demo.adapter;

/**
 * Created by kouyang on 6/4/2015.
 */
public class Adapter extends Source implements Targetable{

    public void method2() {
        System.out.println("targetable method");
    }
}
