package thread;

/**
 * Created by kouyang on 11/27/2015.
 */
public class ThreadDemo {
    public static void main(String[] args) {
        new MyThread().start();
        new MyThread().start();
        new MyThread().start();
    }
}
