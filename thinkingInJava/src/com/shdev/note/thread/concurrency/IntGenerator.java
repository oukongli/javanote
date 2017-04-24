package com.shdev.note.thread.concurrency;

/**
 * Created by ouyangkongli on 2017/4/25.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
