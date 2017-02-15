package com.shdev.note.io;

import java.io.*;

/**
 * Created by ou_ko on 2017/1/18.
 */
public class FreezeAlien {
    public static void main(String[] args) throws IOException {
        ObjectOutput output = new ObjectOutputStream(new FileOutputStream("X.file"));
        Alien alien = new Alien();
        output.writeObject(alien);
    }
}