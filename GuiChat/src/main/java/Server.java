import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.*;

/**
 * Created by oukongli on 2015/1/12.
 */
public class Server {
    public static final int PORT = 5858;
    public static final String HOST = "127.0.0.1";
    public static final String DISCONNECT_TOKEN = "disconnect";
    public static final String TRAN_USER_FLAG = "connect:";

    //private List<ServerThread> cs;
    private Map<String,ServerThread> cs;


    public static void main(String[] args) {
        new Server().startup();
    }

    public void startup(){
        ServerSocket ss = null;

        try {
            ss = new ServerSocket(PORT);
//            cs = new ArrayList<ServerThread>();
            cs = new HashMap<String, ServerThread>();
            while (true){
                try {
                    Socket s = ss.accept();
                    new Thread(new ServerThread(s)).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ss != null)
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    private class ServerThread implements Runnable {
        private Socket s;
        private BufferedReader br;
        private PrintWriter out;
        private String name;
        private boolean stop = false;

        public ServerThread(Socket s) throws IOException {
            this.s = s;
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out = new PrintWriter(s.getOutputStream(), true);
            name = br.readLine();
            name += "[" + s.getInetAddress().getHostAddress() + "]";
            send(name + "连接了");
//            cs.add(this);
            cs.put(name, this);
            sendUser();
        }

        private void sendUser() {
            String us = TRAN_USER_FLAG;
            Set<String> keys = cs.keySet();
            for (String u:keys){
                us+=u+",";
            }
            send(us);
        }

        private void close(){
            stop = true;
            out.println(DISCONNECT_TOKEN);
            cs.remove(name);

            send(name+"断开连接了");
            sendUser();
        }

        private void send(String msg){
//            for (ServerThread st : cs){
//                st.out.println(msg);
//            }
            Set<String> keys = cs.keySet();
            for (String key : keys){
                cs.get(key).out.println(msg);
            }
        }

        @Override
        public void run() {
            try {
                while (true){
                    if (stop)
                        break;
                    String str = br.readLine();
                    if (str.equals(Server.DISCONNECT_TOKEN)){
                        close();
                        break;
                    }
                    send(name + str);
                    System.out.println(name+":"+str);
                }
            } catch (SocketException e) {
                System.out.println(name+ "非正常退出了");
                close();
            } catch (IOException e) {
                e.printStackTrace();
            }   finally {
                if (s != null)
                    try {
                        s.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
        }
    }


}
