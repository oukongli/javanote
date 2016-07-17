package com.shdev.demo.template;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TestTemplate {
    public static void main(String[] args) {
        ExcelTemplate excel = ExcelTemplate.getInstance().readTemplatePath("template.xls");
        excel.createNewRow();
        excel.createNewCol("aaa");
        excel.createNewCol("111");
        excel.createNewCol("111");
        excel.createNewCol("111");
        excel.createNewRow();
        excel.createNewCol("bbb");
        excel.createNewCol("222");
        excel.createNewCol("222");
        excel.createNewCol("222");
        excel.createNewRow();
        excel.createNewCol("ccc");
        excel.createNewCol("333");
        excel.createNewCol("333");
        excel.createNewCol("333");
        excel.createNewRow();
        excel.createNewCol("ddd");
        excel.createNewCol("444");
        excel.createNewCol("444");
        excel.createNewCol("444");
        excel.createNewRow();
        excel.createNewCol("eee");
        excel.createNewCol("555");
        excel.createNewCol("555");
        excel.createNewCol("555");
        Map<String, String> datas = new HashMap<String, String>();
        datas.put("title", "拉斯维加斯");
        datas.put("date", new Date().toString());
        datas.put("department", "百合科技人事部");
        excel.replaceFind(datas);
        excel.insertSer();
        excel.writeToFile("workbook.xls");
    }
}