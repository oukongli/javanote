package com.shdev.demo.mail;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ou_ko on 2016/7/17.
 */
public class TestFreemarker {
    public static void main(String[] args) throws IOException, TemplateException {
        Map<String, Object> root = new HashMap<>();
        root.put("user", "Big Joe");
        Product latest = new Product();
        latest.setUrl("products/greenmouse.html");
        latest.setName("green mouse");
        root.put("latestProduct", latest);
        Template temp = TemplateUtil.getFreeMarkerTemplate("template.ftl");
        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);
    }
}
