package com.shdev.oukongli.demo.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MyDateUtils {
    private static ThreadLocal<SimpleDateFormat> CURRENT_DATE_TIME_FORMAT = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy/MM/dd");
        }
    };

    public static final String CUSTOM_DATE_FORMAT_1;
    public static final String CUSTOM_DATE_FORMAT_2;
    public static final String CUSTOM_DATE_FORMAT_3;
    public static final String CUSTOM_DATE_FORMAT_4;
    public static final String CUSTOM_DATE_FORMAT_5;
    public static final String CUSTOM_DATE_FORMAT_6;
    public static final String CUSTOM_DATE_FORMAT_7;

    static {
        CUSTOM_DATE_FORMAT_1 = "yyyy-MM-dd HH:mm:ss";
        CUSTOM_DATE_FORMAT_2 = "yyyy-MM-dd";
        CUSTOM_DATE_FORMAT_3 = "yyyy/MM/dd";
        CUSTOM_DATE_FORMAT_4 = "yyyyMMdd";
        CUSTOM_DATE_FORMAT_5 = "dd/MM/yyyy HH:mm:ss";
        CUSTOM_DATE_FORMAT_6 = "yyyy-MM-dd HH:mm:ss.SSS";
        CUSTOM_DATE_FORMAT_7 = "yyyy-MM-dd-hh-mm-ss";
    }

    public static final String[] DATE_PATTERNS = {CUSTOM_DATE_FORMAT_1, CUSTOM_DATE_FORMAT_2, CUSTOM_DATE_FORMAT_3, CUSTOM_DATE_FORMAT_4, CUSTOM_DATE_FORMAT_5, CUSTOM_DATE_FORMAT_6, CUSTOM_DATE_FORMAT_7};

    public static Date parseDate(String date) {
        if (StringUtils.isEmpty(date))
            return null;
        try {
            return DateUtils.parseDate(date, DATE_PATTERNS);
        } catch (ParseException e) {
            throw new IllegalArgumentException(String.format("Date format should be one of %s", Arrays.toString(DATE_PATTERNS)));
        }
    }

    public static void main(String[] args) {
        Date date = parseDate("20160602");
        System.out.println(CURRENT_DATE_TIME_FORMAT.get().format(date));
    }
}
