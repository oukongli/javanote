package com.shdev.note.thread.concurrency;

/**
 * Created by ouyangkongli on 2017/4/26.
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public static int nextSerialNumber() {
        return serialNumber++;
    }

}
