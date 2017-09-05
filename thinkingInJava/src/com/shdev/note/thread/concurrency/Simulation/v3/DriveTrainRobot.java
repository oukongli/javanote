package com.shdev.note.thread.concurrency.Simulation.v3;

/**
 * Created by ouyangkongli on 2017/9/6.
 */
public class DriveTrainRobot extends Robot {
    public DriveTrainRobot(RobotPool robotPool) {
        super(robotPool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing DriveTrain");
        assembler.car().addDriveTrain();
    }
}
