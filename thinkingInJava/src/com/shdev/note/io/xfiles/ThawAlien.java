package com.shdev.note.io.xfiles;

import java.io.*;

/**
 * Created by ou_ko on 2017/1/18.
 */
public class ThawAlien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(new File("X.file")));
        Object object = inputStream.readObject();
        System.out.println(object.getClass());
    }
}
