package shdev.oukongli.java.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: oukongli
 * Date: 2014/12/19
 * Time: 23:09
 * To change this template use File | Settings | File Templates.
 */
public class MenuForm extends JFrame {
    public static void main(String[] args) {
        new MenuForm();
    }

    private JMenuBar jMenuBar;
    private JMenu jMenu1,jMenu2,jMenu3;
    private JMenuItem jMenuItem1,jMenuItem2,jMenuItem3,jMenuItem4;

    public MenuForm(){
        setTitle("menu");
        setSize(800, 600);
        setLocation(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jMenuBar = new JMenuBar();
        jMenu1=new JMenu("File");
        jMenu2=new JMenu("Help");
        jMenu3=new JMenu("Save");
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);

        jMenuItem1 = new JMenuItem("Open");
        jMenuItem2 = new JMenuItem("New");
        jMenuItem3 = new JMenuItem("sava...");
        jMenuItem4 = new JMenuItem("sava as ...");

        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem2);
        jMenu1.add(jMenu3);

        jMenu3.add(jMenuItem3);
        jMenu3.add(jMenuItem4);


        this.add(jMenuBar, BorderLayout.NORTH);
        this.setVisible(true);
    }



}
