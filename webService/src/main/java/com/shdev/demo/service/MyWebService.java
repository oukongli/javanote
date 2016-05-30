package com.shdev.demo.service;

import javax.jws.WebService;

/**
 * Created by ou_ko on 2016/4/21.
 */
@SuppressWarnings("restriction")
//SIB (Service implement Bean)
@WebService(endpointInterface = "com.shdev.demo.service.IMyService")
public class MyWebService implements IMyService {
    public int add(int a, int b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a + b;
    }

    public int minus(int a, int b) {
        System.out.println(a + "-" + b + "=" + (a - b));
        return a - b;
    }
}

