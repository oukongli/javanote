package com.shdev.note.thread.concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ouyangkongli on 2017/6/21.
 */
class TaskPortion implements Runnable {
    private static int count = 0;
    private final int id = count++;
    private static Random random = new Random(47);
    private final CountDownLatch countDownLatch;

    public TaskPortion(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            doWork();
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("%1$-3d", id);
    }

    private void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
        System.out.println(this + "completed");
    }
}

class WaitingTask implements Runnable {
    private static int count = 0;
    private final int id = count++;
    private final CountDownLatch countDownLatch;

    public WaitingTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
            System.out.println("Latch barrier passed for " + this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d ", id);
    }
}

public class CountDownLatchDemo {
    static final int SIZE = 100;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new WaitingTask(countDownLatch));
        }
        for (int i = 0; i < SIZE; i++) {
            executorService.execute(new TaskPortion(countDownLatch));
        }
        System.out.println("Launched all tasks");
        executorService.shutdown();
    }
}
