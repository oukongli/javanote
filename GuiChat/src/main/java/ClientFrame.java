import javax.swing.*;
import javax.swing.text.Element;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.List;

/**
 * Created by oukongli on 2015/1/12.
 */
public class ClientFrame extends JFrame {
    private JTextArea jta;
    private JTextField jtf;
    private JPanel jp;
    private JButton jbtn;
    private JScrollPane jsp1, jsp2;
    private JList list;
    private String name;
    private DefaultListModel<String> model;

    public ClientFrame(String name) {
        model = new DefaultListModel<String>();
        model.addElement(name);
        this.setLocation(100, 100);
        this.setSize(800, 600);
        this.name = name;
        this.setTitle("User Client" + name);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        jta = new JTextArea();
        jsp1 = new JScrollPane(jta);
        jtf = new JTextField(35);
        jtf.addKeyListener(new KeyClick());
        jbtn = new JButton("send");
        jbtn.addActionListener(new BtnClick());
        list = new JList(model);
        list.setFixedCellWidth(100);
        jsp2 = new JScrollPane(list);
        jp = new JPanel();

        this.setVisible(true);

        this.add(jsp1);
        jp.add(jtf);
        jp.add(jbtn);
        this.add(jp, BorderLayout.SOUTH);
        this.add(jsp2, BorderLayout.WEST);
    }

    private class KeyClick extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
                send();
        }
    }

    private class BtnClick implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbtn) {
                send();
                List<String> l= list.getSelectedValuesList();
                for (String str : l)
                {
                    System.out.println(str);
                }
            }
        }
    }

    private void send(){
        String word = jtf.getText();
        if (word == null || word.trim().equals(""))
            return;
        jta.setText(jta.getText() + name + ":" + word + "\n");
        jtf.setText("");
    }
}
