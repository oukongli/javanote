package com.shdev.note.thread.concurrency.Simulation.v3;

/**
 * Created by ouyangkongli on 2017/9/6.
 */
public class WheelRobot extends Robot {
    public WheelRobot(RobotPool robotPool) {
        super(robotPool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing Wheels");
        assembler.car().addWheels();
    }
}
