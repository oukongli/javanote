package com.shdev.demo.rest;

import org.springframework.stereotype.Service;

/**
 * Created by ou_ko on 2016/8/5.
 */
@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
    public ExampleModel get(String id) {
        return new ExampleModel("example", 1001);
    }
}
