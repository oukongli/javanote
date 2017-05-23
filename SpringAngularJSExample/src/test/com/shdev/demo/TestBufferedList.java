package com.shdev.demo;

import com.shdev.demo.model.BufferedList;
import org.junit.Test;

import java.util.List;

public class TestBufferedList {
    @Test
    public void testBuffedStringList() {
        BufferedList<String> stringBufferedList = new BufferedList<String>(new BufferedList.CallBack<String>() {
            public void flush(List<String> list) {
                System.out.println(list.size());
            }
        });
        for (int i = 0; i < 789789; i++) {
            stringBufferedList.add("1");
        }
        stringBufferedList.flush();
    }
}
