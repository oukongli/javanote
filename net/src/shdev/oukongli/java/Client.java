package shdev.oukongli.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by oukongli on 2015/1/7.
 */
public class Client {
    public static void main(String[] args) {
        Socket s = null;
        BufferedReader sbr = null;

        try {
            s = new Socket("127.0.0.1", 5858);
            PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            sbr = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String str = null;
            while((str=sbr.readLine()) != null){
                out.println(str);
                String brString = br.readLine();
                if (brString.equals("disconnect"))
                    break;
                System.out.println(brString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (s != null)
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (sbr != null)
                try {
                    sbr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
