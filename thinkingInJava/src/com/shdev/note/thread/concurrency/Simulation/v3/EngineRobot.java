package com.shdev.note.thread.concurrency.Simulation.v3;

/**
 * Created by ouyangkongli on 2017/9/6.
 */
public class EngineRobot extends Robot {
    public EngineRobot(RobotPool robotPool) {
        super(robotPool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing engine");
        assembler.car().addEngine();
    }
}
