package com.shdev.demo.http;

/**
 * Created by ou_ko on 2017/1/11.
 */
public class HttpResponse {
    private int statusCode;
    private String content;

    public HttpResponse(int statusCode, String content) {
        this.statusCode = statusCode;
        this.content = content;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
