package com.shdev.oukongli.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ou_kongli on 2015/4/27.
 */
public class MsgUtil {
    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private static final SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);


    public static String formatDate(Date date) {
        return sdf.format(date);
    }
}
