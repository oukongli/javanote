package com.shdev.demo.service;

import javax.jws.WebService;

/**
 * Created by ou_ko on 2016/4/21.
 */

//SEI Service Endpoint Interface
@WebService
public interface IMyService {
    int add(int a, int b);

    int minus(int a, int b);
}
