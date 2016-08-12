package com.ea.eadp.autoex;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by kouyang on 12/11/2014.
 */
public class LDAPUtil {

    public static String formatSearchFilter(String str) {
        StringBuffer buffer = new StringBuffer(str);
        int index = buffer.indexOf("=");
        while (index != -1) {
            index = buffer.indexOf("=", index + 1);
            if (index != -1) {
                int position = buffer.lastIndexOf(",", index);
                if (position != -1) {
                    buffer.setCharAt(position, '#');
                }
            }
        }

        String[] arrays = buffer.toString().split("#");
        StringBuffer result = new StringBuffer("(&");
        for (String array : arrays) {
            result.append("(")
                    .append(array)
                    .append(")");
        }
        result.append(")");

        return result.toString();
    }

    public static String formatCN(String cn) {
//        cn = cn.replace("\\", "\\5c")
//                .replace("*", "\\2A")
//                .replace("(", "\\28")
//                .replace(")", "\\29");
        cn = cn.replace("\\", "")
                .replace("*", "\\2A")
                .replace("(", "\\28")
                .replace(")", "\\29");
        return "(" + cn + ")";
    }

    public static Properties getProperties(Object object){
        InputStream inputStream = object.getClass().getClassLoader().getResourceAsStream("config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static String[] splitDN(String dn){
        StringBuffer buffer = new StringBuffer(dn);
        int index = buffer.indexOf("=");
        while (index != -1) {
            index = buffer.indexOf("=", index + 1);
            if (index != -1) {
                int position = buffer.lastIndexOf(",", index);
                if (position != -1) {
                    buffer.setCharAt(position, '#');
                }
            }
        }
        return buffer.toString().split("#");
    }

    public static String getLdapHostByDN(String dn){
        String args[] = splitDN(dn);
        StringBuffer buffer = new StringBuffer();
        for (String arg : args){
            if (arg.startsWith("DC=")){
                buffer.append(arg.split("=")[1]).append(".");
            }
        }
        return buffer.substring(0,buffer.length()-1);
    }

    public static String getSearchBaseByDN(String dn){
        String args[] = splitDN(dn);
        StringBuffer buffer = new StringBuffer();
        for (String arg : args){
            if (arg.startsWith("OU=") || arg.startsWith("DC=")){
                buffer.append(arg).append(",");
            }
        }
        return buffer.substring(0,buffer.length()-1);
    }

    public static String getSearchFilterByDN(String dn){
        String args[] = splitDN(dn);
        StringBuffer buffer = new StringBuffer();
        for (String arg : args) {
            if (arg.startsWith("CN=")){
                buffer.append(arg).append(",");
            }
        }
        return formatCN(buffer.substring(0,buffer.length()-1));
    }
}
