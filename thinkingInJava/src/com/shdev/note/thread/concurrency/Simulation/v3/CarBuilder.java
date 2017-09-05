package com.shdev.note.thread.concurrency.Simulation.v3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by ouyangkongli on 2017/9/5.
 */
public class CarBuilder {
    public static void main(String[] args) throws InterruptedException {
        CarQueue chassisQueue = new CarQueue(), finishingQueue = new CarQueue();
        ExecutorService executorService = Executors.newCachedThreadPool();
        RobotPool robotPool = new RobotPool();
        executorService.execute(new EngineRobot(robotPool));
        executorService.execute(new DriveTrainRobot(robotPool));
        executorService.execute(new WheelRobot(robotPool));
        executorService.execute(new Assembler(chassisQueue, finishingQueue, robotPool));
        executorService.execute(new Reporter(finishingQueue));
        executorService.execute(new ChassisBuilder(chassisQueue));
        TimeUnit.SECONDS.sleep(7);
        executorService.shutdownNow();
    }
}
