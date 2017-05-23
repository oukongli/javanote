package com.shdev.note.reg;

/**
 * Created by ou_ko on 2017/3/14.
 */
public class TestReg {
    public static void main(String[] args) {
        String input = "a\\b\\c";
        System.out.println(input.replaceAll("\\\\", "d"));
    }
}
