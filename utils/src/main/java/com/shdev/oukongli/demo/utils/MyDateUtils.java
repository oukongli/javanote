package com.shdev.oukongli.demo.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyDateUtils {
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat(CUSTOM_DATE_FORMAT.FORMAT_3.getDescription());
        }
    };

    public enum CUSTOM_DATE_FORMAT {
        FORMAT_1("yyyy-MM-dd HH:mm:ss"),
        FORMAT_2("yyyy-MM-dd"),
        FORMAT_3("yyyy/MM/dd"),
        FORMAT_4("yyyyMMdd"),
        FORMAT_5("dd/MM/yyyy HH:mm:ss"),
        FORMAT_6("yyyy-MM-dd HH:mm:ss.SSS"),
        FORMAT_7("yyyy-MM-dd-hh-mm-ss");

        CUSTOM_DATE_FORMAT(String description) {
            this.description = description;
        }

        private String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

//    public static final String CUSTOM_DATE_FORMAT_1;
//    public static final String CUSTOM_DATE_FORMAT_2;
//    public static final String CUSTOM_DATE_FORMAT_3;
//    public static final String CUSTOM_DATE_FORMAT_4;
//    public static final String CUSTOM_DATE_FORMAT_5;
//    public static final String CUSTOM_DATE_FORMAT_6;
//    public static final String CUSTOM_DATE_FORMAT_7;
//
//    static {
//        CUSTOM_DATE_FORMAT_1 = "yyyy-MM-dd HH:mm:ss";
//        CUSTOM_DATE_FORMAT_2 = "yyyy-MM-dd";
//        CUSTOM_DATE_FORMAT_3 = "yyyy/MM/dd";
//        CUSTOM_DATE_FORMAT_4 = "yyyyMMdd";
//        CUSTOM_DATE_FORMAT_5 = "dd/MM/yyyy HH:mm:ss";
//        CUSTOM_DATE_FORMAT_6 = "yyyy-MM-dd HH:mm:ss.SSS";
//        CUSTOM_DATE_FORMAT_7 = "yyyy-MM-dd-hh-mm-ss";
//    }
//
//    public static final String[] DATE_PATTERNS = {CUSTOM_DATE_FORMAT_1, CUSTOM_DATE_FORMAT_2, CUSTOM_DATE_FORMAT_3, CUSTOM_DATE_FORMAT_4, CUSTOM_DATE_FORMAT_5, CUSTOM_DATE_FORMAT_6, CUSTOM_DATE_FORMAT_7};

    public static final String[] DATE_PATTERNS;

    static {
        List<String> formatList = new ArrayList<String>();
        for (CUSTOM_DATE_FORMAT format : CUSTOM_DATE_FORMAT.values()) {
            formatList.add(format.getDescription());
        }
        DATE_PATTERNS = formatList.toArray(new String[formatList.size()]);
    }

    public static Date parseDate(String date) {
        if (StringUtils.isEmpty(date))
            return null;
        try {
            return DateUtils.parseDate(date, DATE_PATTERNS);
        } catch (ParseException e) {
            throw new IllegalArgumentException(String.format("Date format %1$s is not supported", date));
        }
    }

    public static String convertDateFormat(String date, CUSTOM_DATE_FORMAT targetFormat) {
        if (StringUtils.isEmpty(date))
            return null;
        return convertDateFormat(parseDate(date), targetFormat);
    }

    public static String convertDateFormat(Date date, CUSTOM_DATE_FORMAT targetFormat) {
        if (date == null)
            return null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(targetFormat.getDescription());
        return dateFormat.format(date);
    }

    public static void main(String[] args) {
        Date date = parseDate("20160602");
        System.out.println(threadLocal.get().format(date));
        System.out.println(convertDateFormat(new Date(), CUSTOM_DATE_FORMAT.FORMAT_6));
        System.out.println(convertDateFormat("20160607", CUSTOM_DATE_FORMAT.FORMAT_1));
    }
}
