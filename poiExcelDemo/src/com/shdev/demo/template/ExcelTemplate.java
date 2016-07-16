package com.shdev.demo.template;

import com.shdev.demo.test.DBObject;
import com.shdev.demo.test.Test;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ou_ko on 2016/7/17.
 */
public class ExcelTemplate {

    public static void main(String[] args) throws IOException {
        InputStream inp = new FileInputStream("template.xls");
        Workbook wb = new HSSFWorkbook(inp);
        wb.getSheetAt(0).createRow(1);
        List<DBObject> dbObjects = new ArrayList<>();
        DBObject dbObject = new DBObject();
        dbObject.setName("11111111111111111");
        dbObject.setId("222222222222222");
        dbObjects.add(dbObject);
        Test.createData(wb.getSheetAt(0), dbObjects, 1);
        Test.writeToExcel(wb);
    }
}
