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
public class TestGrideLayout extends JFrame {
    public static void main(String[] args) {
        new TestGrideLayout();
    }

    private JButton jb1,jb2,jb3,jb4,jb5;
    public TestGrideLayout(){

        setTitle("JAVA 窗口");
        setSize(800, 600);
        setLocation(200, 200);
        setBackground(Color.cyan);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(2,3,10,20));

        jb1 = new JButton("north");
        jb2 = new JButton("south");
        jb3 = new JButton("west");
        jb4 = new JButton("ease");
        jb5 = new JButton("center");
        jb1.setSize(30,10);
        jb2.setSize(30,10);
        add(jb1);
        add(jb2);
        add(jb3);
        add(jb4);
        add(jb5);

        setVisible(true);
    }
}
