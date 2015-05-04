package com.shdev.oukongli.test;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by ou_kongli on 2015/5/4.
 */
public class TestProp {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(TestProp.class.getClassLoader().getResourceAsStream("jdbc.properties"));
        String username = properties.getProperty("usrename");
    }
}
