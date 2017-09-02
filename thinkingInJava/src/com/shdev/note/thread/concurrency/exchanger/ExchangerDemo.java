package com.shdev.note.thread.concurrency.exchanger;

import com.shdev.note.rawtype.BasicGenerator;
import com.shdev.note.rawtype.Generator;
import com.shdev.note.thread.concurrency.semaphore.Fat;

import java.util.List;
import java.util.concurrent.*;

/**
 * Created by ouyangkongli on 2017/9/3.
 */
class ExchangerProducer<T> implements Runnable {
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;

    public ExchangerProducer(Generator<T> generator, Exchanger<List<T>> exchanger, List<T> holder) {
        this.generator = generator;
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < ExchangerDemo.size; i++) {
                    holder.add(generator.next());
                    holder = exchanger.exchange(holder);
                }
            }
        } catch (Exception e) {
            System.out.println("producer:" + e.getClass());
            e.printStackTrace();
        }
    }
}

class ExchangerConsumer<T> implements Runnable {
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;

    public ExchangerConsumer(Exchanger<List<T>> exchanger, List<T> holder) {
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                holder = exchanger.exchange(holder);
                for (T t : holder) {
                    value = t;
                    holder.remove(t);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("consumer:" + e.getClass());
            e.printStackTrace();
        }
        System.out.println("Final value: " + value);
    }
}


public class ExchangerDemo {
    static int size = 10;
    static int delay = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Exchanger<List<Fat>> exchanger = new Exchanger<>();
        List<Fat> producerList = new CopyOnWriteArrayList<>();
        List<Fat> consumerList = new CopyOnWriteArrayList<>();
        executorService.execute(new ExchangerProducer<>(BasicGenerator.create(Fat.class), exchanger, producerList));
        executorService.execute(new ExchangerConsumer<>(exchanger, consumerList));
        TimeUnit.SECONDS.sleep(delay);
        executorService.shutdownNow();
    }
}
