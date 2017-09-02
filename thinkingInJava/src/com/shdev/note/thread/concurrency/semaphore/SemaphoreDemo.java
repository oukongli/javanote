package com.shdev.note.thread.concurrency.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by ouyangkongli on 2017/9/2.
 */
class CheckoutTask<T> implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;

    public CheckoutTask(Pool<T> pool) {
        this.pool = pool;
    }

    @Override
    public void run() {
        try {
            T item = pool.checkout();
            System.out.println(this + "checked out " + item);
            TimeUnit.SECONDS.sleep(1);
            System.out.println(this + "checked in " + item);
            pool.checkIn(item);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "CheckoutTask{" +
                "id=" + id +
                '}';
    }

}

public class SemaphoreDemo {
    final static int SIZE = 25;

    public static void main(String[] args) throws InterruptedException {
        final Pool<Fat> pool = new Pool<>(Fat.class, SIZE);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < SIZE; i++) {
            executorService.execute(new CheckoutTask<>(pool));
        }
        System.out.println("All checkoutTasks created");
        List<Fat> list = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            Fat f = pool.checkout();
            System.out.println(i + ": main() thread checked out ");
            f.operation();
            list.add(f);
        }
        Future<?> blocked = executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    pool.checkout();
                } catch (InterruptedException e) {
                    System.out.println("checkOut() Interrupted");
                }
            }
        });
        TimeUnit.SECONDS.sleep(2);
        blocked.cancel(true);
        System.out.println("Checking in objects in " + list);
        for (Fat fat : list) {
            pool.checkIn(fat);
        }
        for (Fat fat : list) {
            pool.checkIn(fat);
        }
        executorService.shutdown();
    }
}
