package bridge;

import demo.bridge.*;
import org.junit.Test;

/**
 * Created by kouyang on 6/4/2015.
 */
public class TestBridge {
    @Test
    public void testName() throws Exception {
        Bridge bridge = new MyBridge();

        BridgeSourceable source1 = new BridgeSourceSub1();
        bridge.setSource(source1);
        bridge.method();

        BridgeSourceable source2 = new BridgeSourceSub2();
        bridge.setSource(source2);
        bridge.method();
    }
}
