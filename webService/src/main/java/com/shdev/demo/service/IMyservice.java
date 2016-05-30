package com.shdev.demo.service;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * Created by ou_ko on 2016/4/21.
 */

@SuppressWarnings("restriction")
//SEI Service Endpoint Interface
@WebService
public interface IMyService {
    @WebResult(name = "addResult")
    int add(@WebParam(name = "a") int a, @WebParam(name = "b") int b);

    @WebResult(name = "minusResult")
    int minus(@WebParam(name = "a") int a, @WebParam(name = "b") int b);
}
