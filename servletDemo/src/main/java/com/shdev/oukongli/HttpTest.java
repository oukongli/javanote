package com.shdev.oukongli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by ou_kongli on 2015/4/14.
 */
public class HttpTest {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("www.baidu.com", 80);
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            out.println("GET / HTTP/1.1");
            out.println("Host: www.baidu.com");
            out.println("contentType: text/html");
            out.println();
            String str;
            while((str=reader.readLine())!=null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
