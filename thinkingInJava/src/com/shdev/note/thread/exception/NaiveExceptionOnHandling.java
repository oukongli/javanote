package com.shdev.note.thread.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ouyangkongli on 2017/4/24.
 */
public class NaiveExceptionOnHandling {
    static class ExceptionThread implements Runnable {
        @Override
        public void run() {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(new ExceptionThread());
            executorService.shutdown();
        } catch (Exception e) {
            System.out.println("not work");
        }
    }
}
