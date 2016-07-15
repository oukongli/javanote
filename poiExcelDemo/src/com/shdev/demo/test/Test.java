package com.shdev.demo.test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ou_ko on 2016/7/15.
 */
public class Test {
    public static void main(String[] args) {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("new sheet");
        outputList(wb, sheet);

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("workbook.xls");
            wb.write(fileOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null)
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static void outputList(Workbook workbook, Sheet sheet) {
        CreationHelper help = workbook.getCreationHelper();
        for (int i = 0; i < 10; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < 5; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue("" + i + "," + j);
            }
        }
        Row row = sheet.createRow(10);
        for (int j = 0; j < 5; j++) {
            row.createCell(j).setCellValue(help.createRichTextString("This is a string"));
        }
    }
}
