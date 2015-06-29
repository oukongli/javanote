package demo.bridge;

/**
 * Created by kouyang on 6/4/2015.
 */
public abstract class Bridge {
    private BridgeSourceable source;

    public void method() {
        source.method();
    }

    public BridgeSourceable getSource() {
        return source;
    }

    public void setSource(BridgeSourceable source) {
        this.source = source;
    }
}
