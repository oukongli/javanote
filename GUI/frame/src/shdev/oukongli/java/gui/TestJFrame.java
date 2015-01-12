package shdev.oukongli.java.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: oukongli
 * Date: 2014/12/19
 * Time: 22:02
 * To change this template use File | Settings | File Templates.
 */
public class TestJFrame extends JFrame {
    public static void main(String[] args) {
        new TestJFrame();
    }

    private JButton jb1,jb2;
    public TestJFrame(){

        setTitle("JAVA 窗口");
        setSize(800, 600);
        setLocation(200, 200);
        setBackground(Color.cyan);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jb1 = new JButton("hello");
        jb2 = new JButton("world");
        jb1.setSize(30,10);
        jb2.setSize(30,10);
        add(jb1);
        add(jb2);
        setVisible(true);
    }
}
