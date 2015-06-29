package prototype;

import demo.prototype.PrototypePattern;
import demo.prototype.SerializableObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by kouyang on 6/4/2015.
 */
public class TestPrototypePattern {
    @Test
    public void test() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        PrototypePattern prototype = new PrototypePattern();
        prototype.setObj(new SerializableObject());
        prototype.getObj().setNames(new ArrayList<String>());
        prototype.setString("test string");
        prototype.setNum(1);

        PrototypePattern copy = (PrototypePattern) prototype.clone();
        Assert.assertEquals(prototype.getNum(), copy.getNum());
        Assert.assertSame(prototype.getString(), copy.getString());
        Assert.assertSame(prototype.getObj(), copy.getObj());
        Assert.assertSame(prototype.getObj().getNames(), copy.getObj().getNames());

        PrototypePattern deepCopy = (PrototypePattern) prototype.deepClone();
        Assert.assertEquals(prototype.getNum(), deepCopy.getNum());
        Assert.assertEquals(prototype.getString(), deepCopy.getString());
        Assert.assertNotSame(prototype.getString(), deepCopy.getString());
        Assert.assertNotSame(prototype.getObj(), deepCopy.getObj());
        Assert.assertNotSame(prototype.getObj().getNames(), deepCopy.getObj().getNames());
        Assert.assertArrayEquals(prototype.getObj().getNames().toArray(), deepCopy.getObj().getNames().toArray());
    }
}
