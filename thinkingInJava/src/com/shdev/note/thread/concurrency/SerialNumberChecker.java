package com.shdev.note.thread.concurrency;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ouyangkongli on 2017/4/26.
 */
public class SerialNumberChecker {
    static class CircularSet {
        private int[] array;
        private int len;
        private int index = 0;

        public CircularSet(int size) {
            array = new int[size];
            len = size;
            for (int i = 0; i < size; i++) {
                array[i] = -1;
            }
        }

        public synchronized void add(int i) {
            array[index] = i;
            index = ++index % len;
        }

        public synchronized boolean contains(int val) {
            for (int i = 0; i < len; i++) {
                if (array[i] == val)
                    return true;
            }
            return false;
        }
    }

    private static final int SIZE = 20;
    private static CircularSet serials = new CircularSet(1000);
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable {
        @Override
        public void run() {
            while (true) {
                int serial = SerialNumberGenerator.nextSerialNumber();
                if (serials.contains(serial)) {
                    System.out.println("Duplicate: " + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            executorService.execute(new SerialChecker());
        }
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("no duplicates detected");
        System.exit(0);
    }
}
