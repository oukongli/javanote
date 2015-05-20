package com.shdev.oukongli.java;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

/**
 * Created by ou_kongli on 2015/5/20.
 */
public class TestUser {
    @Test
    public void test01() {
        User user = new User();
        String value = "oukongli";
        String key = "username";
        try {
            BeanUtils.copyProperty(user, key, value);
            BeanUtils.copyProperty(user, "age", 111);

            //set Date Type
            ConvertUtils.register(new DateConvert<Date>(), Date.class);
            BeanUtils.copyProperty(user, "birthday", "1989-08-21");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user.getUsername());
    }
}
