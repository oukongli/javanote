package proxy;

import demo.proxy.Proxy;
import demo.proxy.Sourceable;
import org.junit.Test;

/**
 * Created by kouyang on 6/4/2015.
 */
public class TestProxy {
    @Test
    public void testName() throws Exception {
        Sourceable source = new Proxy();
        source.method();
    }
}
