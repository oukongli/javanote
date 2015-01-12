import javax.management.remote.JMXConnectorFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Created by oukongli on 2015/1/12.
 */
public class LoginFrame extends JFrame{
    private JLabel jl;
    private JButton jbtn;
    private JTextField jtf;

    public static void main(String[] args) {
        new LoginFrame();
    }

    public LoginFrame(){
        this.setLocation(100,100);
        this.setSize(400,100);
        this.setTitle("User Connect");
        this.setResizable(false);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        jl = new JLabel("输入用户名");
        jtf = new JTextField(20);
        jbtn = new JButton("连接");
        jbtn.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = jtf.getText();
                if (name == null || name.trim().equals(""))
                {
//                    JOptionPane.showConfirmDialog(null,"null");
//                    String str = JOptionPane.showInputDialog("输入你的用户名");
                    JOptionPane.showMessageDialog(null, "输入你的用户名");
                    return;
                }
                new ClientFrame(name);
                close();
            }
        });

        this.add(jl);
        this.add(jtf);
        this.add(jbtn);

        this.setVisible(true);
    }

    private void close(){
        this.setVisible(false);
    }

}
