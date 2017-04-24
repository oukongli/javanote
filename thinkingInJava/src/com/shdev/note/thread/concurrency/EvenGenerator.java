package com.shdev.note.thread.concurrency;

/**
 * Created by ouyangkongli on 2017/4/25.
 */
public class EvenGenerator extends IntGenerator {
    private int currentVal = 0;

    @Override
    public int next() {
        ++currentVal;
        ++currentVal;
        return currentVal;
    }

    public static void main(String[] args) {
        EventChecker.test(new EvenGenerator(), 5);
        System.out.println("---------");
        EventChecker.test(new EvenGenerator());
    }

}
