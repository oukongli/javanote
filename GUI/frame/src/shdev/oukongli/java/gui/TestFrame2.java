package shdev.oukongli.java.gui;

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: oukongli
 * Date: 2014/12/18
 * Time: 23:53
 * To change this template use File | Settings | File Templates.
 */
public class TestFrame2 extends Frame{
    public static void main(String[] args) {
        new TestFrame2();
    }

    public TestFrame2(){
        setTitle("JAVA 窗口");
        setSize(300, 400);
        setLocation(200, 200);
        setVisible(true);
    }
}
