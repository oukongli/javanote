package com.shdev.note.thread.concurrency.Simulation.v3;

import java.util.concurrent.BrokenBarrierException;

/**
 * Created by ouyangkongli on 2017/9/6.
 */
public abstract class Robot implements Runnable {
    private RobotPool robotPool;

    public Robot(RobotPool robotPool) {
        this.robotPool = robotPool;
    }

    protected Assembler assembler;

    public Robot assignAssembler(Assembler assembler) {
        this.assembler = assembler;
        return this;
    }

    private boolean engage = false;

    public synchronized void engage() {
        engage = true;
        notifyAll();
    }

    abstract protected void performService();

    @Override
    public void run() {
        try {
            powerDown();
            while (!Thread.interrupted()) {
                performService();
                assembler.barrier().await();
                powerDown();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting " + this + " via interrupt");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this + " off");
    }

    private synchronized void powerDown() throws InterruptedException {
        engage = false;
        assembler = null;
        robotPool.release(this);
        while (engage == false)
            wait();
    }

    @Override
    public String toString() {
        return getClass().getName();
    }
}
