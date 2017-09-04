package com.shdev.note.thread.concurrency.Simulation;

/**
 * Created by ouyangkongli on 2017/9/5.
 */
public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Coffee.class),
    COFFEE(Food.Coffee.class);
    private Food[] values;

    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }
}




