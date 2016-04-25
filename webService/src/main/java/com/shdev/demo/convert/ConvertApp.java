package com.shdev.demo.convert;

/**
 * Created by ou_ko on 2016/4/25.
 */
public class ConvertApp {
    public static void main(String[] args) {
        Convert convert;
        convert = new Java2Xml();
//        convert = new Xml2Java();
        convert.convert();
    }
}
