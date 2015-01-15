import java.io.IOException;
import java.net.*;

/**
 * Created by oukongli on 2015/1/15.
 */
public class UDPSender {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket();
            String hello = "hello world";
            DatagramPacket dp = new DatagramPacket(hello.getBytes(),hello.getBytes().length,new InetSocketAddress("127.0.0.1",9999));
            for (int i=1;i<=10;i++){
                Thread.sleep(500);
                ds.send(dp);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            if (ds !=null)
                ds.close();
        }
    }
}
