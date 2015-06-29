package demo.prototype;

import demo.PatternDemo;

import java.io.*;

/**
 * Created by kouyang on 6/3/2015.
 */
public class PrototypePattern implements PatternDemo, Serializable, Cloneable {
    private String string;
    private SerializableObject obj;
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Object clone() throws CloneNotSupportedException {
        PrototypePattern proto = (PrototypePattern) super.clone();
        return proto;
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }

}
