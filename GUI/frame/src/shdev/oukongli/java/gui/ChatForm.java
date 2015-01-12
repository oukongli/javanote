package shdev.oukongli.java.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: oukongli
 * Date: 2014/12/19
 * Time: 22:55
 * To change this template use File | Settings | File Templates.
 */
public class ChatForm extends JFrame {
    public static void main(String[] args) {
        new ChatForm();
    }

    private JPanel jPanel;
    private JTextArea jTextArea;
    private JComboBox jComboBox;
    private JTextField jTextField;
    private JButton jButton;
    private JScrollPane jScrollPane;

    public ChatForm(){
        this.setTitle("聊天");
        this.setLocation(200, 200);
        this.setSize(650, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        jTextArea = new JTextArea();
//        this.add(jTextArea);
        jScrollPane = new JScrollPane(jTextArea);
        this.add(jScrollPane);

        jPanel = new JPanel();
        jComboBox = new JComboBox(new String[]{"123","4560"});
        jTextField = new JTextField(20);
        jButton = new JButton("发送");
        jPanel.add(jComboBox);
        jPanel.add(jTextField);
        jPanel.add(jButton);
        this.add(jPanel,BorderLayout.SOUTH);

        this.setVisible(true);

    }
}
