package sockTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kouyang on 2/26/2016.
 */
public class EchoServer {
    private static final int ECHO_SERVER_PORT = 6789;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(ECHO_SERVER_PORT);
            System.out.println("Server is starting up");
            while (true) {
                Socket client = server.accept();
                new Thread(new ClientHandler(client)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {
        private Socket client;

        public ClientHandler(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter printWriter = new PrintWriter(client.getOutputStream());
                String msg = bufferedReader.readLine();
                System.out.println("received " + msg + "from" + client.getInetAddress());
                printWriter.println(msg);
                printWriter.flush();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
