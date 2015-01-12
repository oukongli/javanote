package shdev.oukongli.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Created by oukongli on 2015/1/7.
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket ss = null;
        Socket s = null;

        try {
            ss = new ServerSocket(5858);

                while(true){
                    try {
                        s = ss.accept();
                        String name = s.getInetAddress().getHostAddress()+":"+s.getPort();
                        System.out.println(name+" connected");
                        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                        String str = null;
                        while((str = br.readLine()) != null){
                            if (str.equalsIgnoreCase("quit")){
                                out.println("disconnect");
                                break;
                            }
                            System.out.println(str);
                            out.println("Receive:" + str);
                        }
                        System.out.println(name+" quit");
                    } catch (UnknownHostException e){
                        e.printStackTrace();
                    }  catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (s != null)
                            try {
                                s.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
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
}
