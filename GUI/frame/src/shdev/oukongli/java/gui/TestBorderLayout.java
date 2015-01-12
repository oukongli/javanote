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
public class TestBorderLayout extends JFrame {
    public static void main(String[] args) {
        new TestBorderLayout();
    }

    private JButton jb1,jb2,jb3,jb4,jb5;
    public TestBorderLayout(){

        setTitle("JAVA 窗口");
        setSize(800, 600);
        setLocation(200, 200);
        setBackground(Color.cyan);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jb1 = new JButton("north");
        jb2 = new JButton("south");
        jb3 = new JButton("west");
        jb4 = new JButton("ease");
        jb5 = new JButton("center");
        jb1.setSize(30,10);
        jb2.setSize(30,10);
        add(jb1, BorderLayout.NORTH);
        add(jb2, BorderLayout.SOUTH);
        add(jb3, BorderLayout.WEST);
        add(jb4, BorderLayout.EAST);
        add(jb5, BorderLayout.CENTER);


        setVisible(true);
    }
}
