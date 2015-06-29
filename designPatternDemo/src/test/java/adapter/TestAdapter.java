package adapter;

import demo.adapter.*;
import org.junit.Test;

/**
 * Created by kouyang on 6/4/2015.
 */
public class TestAdapter {
    @Test
    public void test() {
        //类的适配器模式
        Targetable target = new Adapter();
        target.method1();
        target.method2();
    }

    @Test
    public void test2() throws Exception {
        //对象的适配器模式
        Targetable target = new Wrapper(new Source());
        target.method1();
        target.method2();
    }

    @Test
    public void test3() throws Exception {
        //接口适配器
        Sourceable sourceable1 = new SourceSub1();
        sourceable1.method1();
        sourceable1.method2();
        Sourceable sourceable2 = new SourceSub2();
        sourceable2.method1();
        sourceable2.method2();
    }
}
