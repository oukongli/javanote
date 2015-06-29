package facade;

import demo.facade.Computer;
import org.junit.Test;

/**
 * Created by kouyang on 6/4/2015.
 */
public class TestFacade {
    @Test
    public void testName() throws Exception {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
