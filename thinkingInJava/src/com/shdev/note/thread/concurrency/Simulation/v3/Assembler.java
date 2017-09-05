package com.shdev.note.thread.concurrency.Simulation.v3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by ouyangkongli on 2017/9/6.
 */
public class Assembler implements Runnable {
    private CarQueue chassisQueue, finishingQueue;
    private Car car;
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4);
    private RobotPool robotPool;

    public Assembler(CarQueue chassisQueue, CarQueue finishingQueue, RobotPool robotPool) {
        this.chassisQueue = chassisQueue;
        this.finishingQueue = finishingQueue;
        this.robotPool = robotPool;
    }

    public Car car() {
        return car;
    }

    public CyclicBarrier barrier() {
        return cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car = chassisQueue.take();
                robotPool.hire(EngineRobot.class, this);
                robotPool.hire(DriveTrainRobot.class, this);
                robotPool.hire(WheelRobot.class, this);
                cyclicBarrier.await();
                finishingQueue.put(car);
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting Assembler via interrupt");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Assembler off");
    }
}
