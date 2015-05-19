package com.oukongli.util;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by ou_kongli on 2015/5/4.
 */
public class PropertiesUtil {
    private static Properties jdbcProp;

    public static Properties getJdbcProp(){
        try {
            if (jdbcProp == null) {
                jdbcProp = new Properties();
                jdbcProp.load(PropertiesUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  jdbcProp;
    }
}
