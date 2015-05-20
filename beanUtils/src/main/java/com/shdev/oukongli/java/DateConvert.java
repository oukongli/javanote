package com.shdev.oukongli.java;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ou_kongli on 2015/5/20.
 */
public class DateConvert<T> implements Converter {
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public <T> T convert(Class<T> clazz, Object value) {
        if (clazz != Date.class)
            return null;
        if (value instanceof String) {
            try {
                return (T) sdf.parse((String)value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
