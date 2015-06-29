package decorator;

import demo.decorator.Decorator;
import demo.decorator.Source;
import demo.decorator.Sourceable;
import org.junit.Test;

/**
 * Created by kouyang on 6/4/2015.
 */
public class TestDecorator {
    @Test
    public void testName() throws Exception {
        Sourceable source = new Source();
        Sourceable target = new Decorator(source);
        target.method();
    }
}
