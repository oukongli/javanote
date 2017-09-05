package com.shdev.note.thread.concurrency.Simulation.v3;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ouyangkongli on 2017/9/6.
 */
public class RobotPool {
    private Set<Robot> pool = new HashSet<>();

    public synchronized void add(Robot robot) {
        pool.add(robot);
        notifyAll();
    }

    public synchronized void hire(Class<? extends Robot> robotType, Assembler assembler) throws InterruptedException {
        for (Robot robot : pool) {
            if (robot.getClass().equals(robotType)) {
                pool.remove(robot);
                robot.assignAssembler(assembler);
                robot.engage();
                return;
            }
        }
        wait();
        hire(robotType, assembler);
    }

    public synchronized void release(Robot robot) {
        add(robot);
    }
}
