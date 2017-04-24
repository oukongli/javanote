package com.shdev.note.thread.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by ouyangkongli on 2017/4/24.
 */
public class CaptureUncaughtException {
    static class ExceptionThread implements Runnable {
        @Override
        public void run() {
            Thread t = Thread.currentThread();
            System.out.println("run by " + t);
            System.out.println("uncaught exception handler" + t.getUncaughtExceptionHandler());
            throw new RuntimeException();
        }
    }

    static class CustomExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("caught" + e);
        }
    }

    static class HandlerThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setUncaughtExceptionHandler(new CustomExceptionHandler());
            System.out.println("uncaught exception handler" + thread.getUncaughtExceptionHandler());
            return thread;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(new HandlerThreadFactory());
        executorService.execute(new ExceptionThread());
        executorService.shutdown();
    }
}
