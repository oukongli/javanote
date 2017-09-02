package com.shdev.note.thread.concurrency.semaphore;

/**
 * Created by ouyangkongli on 2017/9/2.
 */
public class Fat {
    private volatile double d;
    private static int counter = 0;
    private int id = counter++;

    public Fat() {
        for (int i = 0; i < 10000; i++) {
            d += (Math.PI + Math.E) / (double) i;
        }
    }

    @Override
    public String toString() {
        return "Fat{" +
                "id=" + id +
                '}';
    }


    public void operation() {
        System.out.println(this);
    }
}
