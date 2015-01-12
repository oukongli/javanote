package shdev.oukongli.java.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: oukongli
 * Date: 2014/12/19
 * Time: 22:33
 * To change this template use File | Settings | File Templates.
 */
public class LoginForm extends JFrame {
    private JPanel jp1,jp2,jp3;
    private JButton jb1,jb2;
    private JLabel jl1,jl2;
    private JTextField jTextField;
    private JPasswordField jPasswordField;

    public static void main(String[] args) {
        new LoginForm();
    }

    public LoginForm() {
        this.setTitle("user login");
        this.setLocation(200, 200);
        this.setSize(300, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3,1));
        jp1 = new JPanel();
        jl1 = new JLabel("用户名");
        jTextField = new JTextField(20);
        jp1.add(jl1);
        jp1.add(jTextField);

        jp2 = new JPanel();
        jl2 = new JLabel("密  码");
        jPasswordField = new JPasswordField(20);
        jp2.add(jl2);
        jp2.add(jPasswordField);

        jp3 = new JPanel();
        jb1 = new JButton("登录");
        jb2 = new JButton("取消");
        jp3.add(jb1);
        jp3.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setResizable(false);
        this.setVisible(true);
    }
}
