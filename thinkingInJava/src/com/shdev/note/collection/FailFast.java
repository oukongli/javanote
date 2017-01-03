package com.shdev.note.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Created by ou_ko on 2017/1/3.
 */
public class FailFast {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();
        Iterator<String> iterator = collection.iterator();
        collection.add("1");
        try {
            String data = iterator.next();
            System.out.println(data);
        } catch (ConcurrentModificationException e) {
            e.printStackTrace();
        }
    }
}
