package com.shdev.note.thread.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ouyangkongli on 2017/4/26.
 */
public class AttemptLocking {
    private ReentrantLock reentrantLock = new ReentrantLock();

    public void unTimed() {
        boolean captured = reentrantLock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured)
                reentrantLock.unlock();
        }

    }

    public void timed() {
        boolean captured = false;
        try {
            captured = reentrantLock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured)
                reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        final AttemptLocking attemptLocking = new AttemptLocking();
        attemptLocking.unTimed();
        attemptLocking.timed();
        new Thread() {
            {
                setDaemon(true);
            }
            @Override
            public void run() {
                attemptLocking.reentrantLock.lock();
                System.out.println("acquired");
            }
        }.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        attemptLocking.unTimed();
        attemptLocking.timed();
    }


}
