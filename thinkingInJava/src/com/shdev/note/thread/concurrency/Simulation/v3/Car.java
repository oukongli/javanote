package com.shdev.note.thread.concurrency.Simulation.v3;

/**
 * Created by ouyangkongli on 2017/9/6.
 */
public class Car {
    private final int id;
    private boolean engine = false, driveTrain = false, wheels = false;

    public Car(int id) {
        this.id = id;
    }

    public synchronized int getId() {
        return id;
    }

    public synchronized void addEngine() {
        engine = true;
    }

    public synchronized void addDriveTrain() {
        driveTrain = true;
    }

    public synchronized void addWheels() {
        wheels = true;
    }

    @Override
    public synchronized String toString() {
        return "Car{" +
                "id=" + id +
                ", engine=" + engine +
                ", driveTrain=" + driveTrain +
                ", wheels=" + wheels +
                '}';
    }


}
