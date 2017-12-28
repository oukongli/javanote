package com.shdev.note.thread.concurrency.lock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ouyangkongli on 2017/9/14.
 */
public class ReaderWriterListTest {
    ExecutorService executorService = Executors.newCachedThreadPool();
    private final static int SIZE = 100;
    private static Random random = new Random(47);
    private ReaderWriterList<Integer> list = new ReaderWriterList<>(SIZE, 0);

    private class Writer implements Runnable {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 20; i++) {
                    list.set(i, random.nextInt());
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            } catch (InterruptedException e) {
            }
            System.out.println("Writer finished, shutting down");
            executorService.shutdownNow();
        }
    }

    private class Reader implements Runnable {
        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    for (int i = 0; i < SIZE; i++) {
                        list.get(i);
                        TimeUnit.MILLISECONDS.sleep(1);
                    }
                }
            } catch (InterruptedException e) {
            }
        }
    }

    public ReaderWriterListTest(int readers, int writers) {
        for (int i = 0; i < readers; i++) {
            executorService.execute(new Reader());
        }
        for (int i = 0; i < writers; i++) {
            executorService.execute(new Writer());
        }
    }
}
