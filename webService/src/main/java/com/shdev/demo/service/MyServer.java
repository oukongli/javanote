package com.shdev.demo.service;

import javax.xml.ws.Endpoint;

/**
 * Created by ou_ko on 2016/4/21.
 */
@SuppressWarnings("restriction")
public class MyServer {
    public static void main(String[] args) {
        String address = "http://localhost:8888/ns";
        Endpoint.publish(address, new MyWebService());
    }
}
