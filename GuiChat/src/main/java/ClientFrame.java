import javax.swing.*;
import javax.swing.text.Element;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
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
    private Socket s;
    private BufferedReader br;
    private PrintWriter out;
    private boolean stop = false;

    public ClientFrame(String name) {
        model = new DefaultListModel<String>();
        model.addElement(name);
        this.setLocation(100, 100);
        this.setSize(800, 600);
        this.name = name;
        this.setTitle("User Client" + name);
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                out.println(Server.DISCONNECT_TOKEN);
            }
        });

        jta = new JTextArea();
        jsp1 = new JScrollPane(jta);
        jtf = new JTextField(35);
        jtf.addKeyListener(new KeyClick());
        jbtn = new JButton("send");
        jbtn.addActionListener(new BtnClick());
        list = new JList(model);
        list.setFixedCellWidth(150);
        jsp2 = new JScrollPane(list);
        jp = new JPanel();

        this.add(jsp1);
        jp.add(jtf);
        jp.add(jbtn);
        this.add(jp, BorderLayout.SOUTH);
        this.add(jsp2, BorderLayout.WEST);

        connect();
        this.setVisible(true);
    }

    private void connect() {
        try {
            s = new Socket(Server.HOST, Server.PORT);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream(), true);
            out.println(name);
            new Thread(new ReceiveThread()).start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            }
        }
    }

    private void send() {
        String word = jtf.getText();
        if (word == null || word.trim().equals(""))
            return;
        jtf.setText("");
        out.println(word);
    }

    private class ReceiveThread implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    if (stop)
                        break;
                    receive();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (s != null)
                        s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        }
    }

    private void receive() throws IOException {
        String str = br.readLine();
        if (str.equals(Server.DISCONNECT_TOKEN))
            close();
        if (str.startsWith(Server.TRAN_USER_FLAG)) {
            handleList(str);
            return;
        }
        jta.setText(jta.getText() + str + "\n");
    }

    private void handleList(String str) {
        String users = str.substring(Server.TRAN_USER_FLAG.length());
        String[] us = users.split(",");
        model.removeAllElements();
        for (String u : us) {
            model.addElement(u);
        }
    }

    private void close() {
        stop = true;
    }


}
