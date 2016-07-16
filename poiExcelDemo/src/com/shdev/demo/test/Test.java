package com.shdev.demo.test;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Test {
    public static void main(String[] args) {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("new sheet");


        List<String> titleList = new ArrayList<>();
        titleList.add("id");
        titleList.add("name");
        for (int i = 1; i <= 25; i++) {
            titleList.add("col_" + i);
        }

        List<DBObject> dataList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            DBObject object = new DBObject();
            object.setId("id_" + i);
            object.setName("name_" + i);
            object.setCol_1(getUUID());
            object.setCol_2(getUUID());
            object.setCol_3(getUUID());
            object.setCol_4(getUUID());
            object.setCol_5(getUUID());
            object.setCol_6(getUUID());
            object.setCol_7(getUUID());
            object.setCol_8(getUUID());
            object.setCol_9(getUUID());
            object.setCol_10(getUUID());
            object.setCol_11(getUUID());
            object.setCol_12(getUUID());
            object.setCol_13(getUUID());
            object.setCol_14(getUUID());
            object.setCol_15(getUUID());
            object.setCol_16(getUUID());
            object.setCol_17(getUUID());
            object.setCol_18(getUUID());
            object.setCol_19(getUUID());
            object.setCol_20(getUUID());
            object.setCol_21(getUUID());
            object.setCol_22(getUUID());
            object.setCol_23(getUUID());
            object.setCol_24(getUUID());
            object.setCol_25(getUUID());
            dataList.add(object);
        }
        createTitle(wb, sheet, titleList, 0);
        createData(sheet, dataList, 1);

        for (int i = 0; i < 24; i++) {
            sheet.autoSizeColumn(i);
        }


       writeToExcel(wb);
    }

    public static void writeToExcel(Workbook wb) {
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


    private static void createTitle(Workbook wb, Sheet sheet, List<String> titleList, int rowNum) {
        Row titleRow = sheet.createRow(rowNum);
        CellStyle style = getTitleCellStyle(wb);
        for (int i = 0; i < titleList.size(); i++) {
            Cell cell = titleRow.createCell(i);
            cell.setCellStyle(style);
            cell.setCellValue(titleList.get(i));
        }
    }

    public static void createData(Sheet sheet, List<DBObject> dbObjects, int rowNum) {
        for (int i = 0; i < dbObjects.size(); i++) {
            Row row = sheet.createRow(rowNum + i);
            DBObject dbObject = dbObjects.get(i);
            int j = 0;
            row.createCell(j++).setCellValue(dbObject.getId());
            row.createCell(j++).setCellValue(dbObject.getName());
            row.createCell(j++).setCellValue(dbObject.getCol_1());
            row.createCell(j++).setCellValue(dbObject.getCol_2());
            row.createCell(j++).setCellValue(dbObject.getCol_3());
            row.createCell(j++).setCellValue(dbObject.getCol_4());
            row.createCell(j++).setCellValue(dbObject.getCol_5());
            row.createCell(j++).setCellValue(dbObject.getCol_6());
            row.createCell(j++).setCellValue(dbObject.getCol_7());
            row.createCell(j++).setCellValue(dbObject.getCol_8());
            row.createCell(j++).setCellValue(dbObject.getCol_9());
            row.createCell(j++).setCellValue(dbObject.getCol_10());
            row.createCell(j++).setCellValue(dbObject.getCol_11());
            row.createCell(j++).setCellValue(dbObject.getCol_12());
            row.createCell(j++).setCellValue(dbObject.getCol_13());
            row.createCell(j++).setCellValue(dbObject.getCol_14());
            row.createCell(j++).setCellValue(dbObject.getCol_15());
            row.createCell(j++).setCellValue(dbObject.getCol_16());
            row.createCell(j++).setCellValue(dbObject.getCol_17());
            row.createCell(j++).setCellValue(dbObject.getCol_18());
            row.createCell(j++).setCellValue(dbObject.getCol_19());
            row.createCell(j++).setCellValue(dbObject.getCol_20());
            row.createCell(j++).setCellValue(dbObject.getCol_21());
            row.createCell(j++).setCellValue(dbObject.getCol_22());
            row.createCell(j++).setCellValue(dbObject.getCol_23());
            row.createCell(j++).setCellValue(dbObject.getCol_24());
            row.createCell(j).setCellValue(dbObject.getCol_25());
        }
    }

    public static CellStyle getTitleCellStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);

        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBorderLeft(CellStyle.BORDER_THIN);

        Font font = wb.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        style.setFont(font);
        return style;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
