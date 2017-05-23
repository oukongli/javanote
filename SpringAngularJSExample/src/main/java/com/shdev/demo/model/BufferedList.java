package com.shdev.demo.model;

import java.util.ArrayList;
import java.util.List;

public class BufferedList<T> {
    private static final int DEFAULT_BUFFER_SIZE = 512;
    private List<T> dataList;
    private int bufferSize;
    private CallBack<T> callBack;

    public BufferedList(int bufferSize, CallBack<T> callBack) {
        this.bufferSize = bufferSize;
        this.dataList = new ArrayList<T>();
        this.callBack = callBack;
    }

    public BufferedList(CallBack<T> callBack) {
        this(DEFAULT_BUFFER_SIZE, callBack);
    }

    public void flush() {
        if (dataList.isEmpty())
            return;
        callBack.flush(dataList);
        dataList.clear();
    }

    public void add(T data) {
        dataList.add(data);
        if (dataList.size() >= bufferSize)
            flush();
    }

    public interface CallBack<T> {
        void flush(List<T> list);
    }
}
