package com.shdev.demo.service;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ou_ko on 2016/4/21.
 */
@SuppressWarnings("restriction")
public class TestClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8888/ns?wsdl");
        QName qName = new QName("http://service.demo.shdev.com/", "MyWebServiceService");
        Service service = Service.create(url, qName);
        IMyService myService = service.getPort(IMyService.class);
        System.out.println(myService.add(1, 2));
    }
}
