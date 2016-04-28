package thread;

/**
 * Created by kouyang on 11/27/2015.
 */
public class MyThread extends Thread {
    private int ticket = 10;

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            if (ticket > 0)
                System.out.println(ticket--);
        }
    }
}
