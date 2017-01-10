package com.shdev.demo.http;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.io.InputStream;

/**
 * Apache Httpclient 工具包装类 <br>
 * required httpclient-4.3
 * Created by ou_ko on 2017/1/11.
 */
public enum HttpClient {
    TEST;

    private SchemeRegistry schemeRegistry;
    private PoolingClientConnectionManager connectionManager;
    private org.apache.http.client.HttpClient client;
    private static final Logger logger = Logger.getLogger(HttpClient.class);

    HttpClient() {
        schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", 80, PlainSocketFactory.getSocketFactory()));
        schemeRegistry.register(new Scheme("https", 443, SSLSocketFactory.getSocketFactory()));
        connectionManager = new PoolingClientConnectionManager(schemeRegistry);
        connectionManager.setMaxTotal(200);
        connectionManager.setDefaultMaxPerRoute(10);
        client = new DefaultHttpClient(connectionManager);
    }

    public HttpResponse getHttpResponse(String url, Header... headers) {
        InputStream input = null;
        HttpGet get = new HttpGet(UriBuilder.fromPath(url).build());
        HttpConnectionParams.setSoTimeout(get.getParams(), 30000);
        HttpConnectionParams.setConnectionTimeout(get.getParams(), 30000);
        get.setHeaders(headers);
        try {
            org.apache.http.HttpResponse response = client.execute(get);
            int returnCode = response.getStatusLine().getStatusCode();
            HttpEntity entity = response.getEntity();
            String content = EntityUtils.toString(entity);
            input = response.getEntity().getContent();
            return new HttpResponse(returnCode, content);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw new RuntimeException("http client internal error.");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
        }
    }
}