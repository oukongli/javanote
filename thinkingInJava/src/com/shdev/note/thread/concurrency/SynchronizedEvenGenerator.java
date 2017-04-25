package com.shdev.note.thread.concurrency;

/**
 * Created by ouyangkongli on 2017/4/26.
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentVal = 0;

    @Override
    public synchronized int next() {
        ++currentVal;
        ++currentVal;
        return currentVal;
    }

    public static void main(String[] args) {
        EventChecker.test(new SynchronizedEvenGenerator(), 5);
    }
}
