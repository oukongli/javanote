package sockTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by kouyang on 2/29/2016.
 */
public class EchoClient {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("localhost", 6789);
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input");
        String msg = scanner.nextLine();
        scanner.close();
        PrintWriter printWriter = new PrintWriter(client.getOutputStream());
        printWriter.println(msg);
        printWriter.flush();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println(bufferedReader.readLine());
        client.close();
    }
}
