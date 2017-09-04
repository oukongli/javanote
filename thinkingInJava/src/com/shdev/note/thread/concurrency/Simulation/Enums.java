package com.shdev.note.thread.concurrency.Simulation;

import java.util.Random;

/**
 * Created by ouyangkongli on 2017/9/5.
 */
public class Enums {
    private static Random random = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> clazz) {
        return random(clazz.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[random.nextInt(values.length)];
    }
}
