package com.shdev.demo.service;

import com.shdev.demo.DBManager;
import com.shdev.demo.DBManager4Oracle;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ou_ko on 2016/12/22.
 */
public class ExportDataToCSV {

    private static final String SEPARATOR = ",";
    private static final int FETCH_SIZE = 10000;

    public void export(String tableName) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            File file = new File(tableName + ".csv");
            if (file.exists() && !file.delete()) {
                throw new RuntimeException("delete file failed");
            }
            connection = DBManager4Oracle.getConnection();
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            statement.setFetchSize(FETCH_SIZE);
            resultSet = statement.executeQuery(String.format("select * from %1$s", tableName));
            processSearchResult(resultSet, file);
        } catch (Exception e) {
            throw new RuntimeException("fail", e);
        } finally {
            DBManager.closeStatement(statement, resultSet);
            DBManager.releaseConnection(connection);
        }
    }


    private void processSearchResult(ResultSet resultSet, File file) throws SQLException, FileNotFoundException {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file))));
            int size = writeFileHead(resultSet, printWriter);
            writeFileBody(resultSet, printWriter, size);
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

    private void writeFileBody(ResultSet resultSet, PrintWriter printWriter, int size) throws SQLException {
        List<String> dataList = new ArrayList<String>(size);
        while (resultSet.next()) {
            for (int i = 1; i <= size; i++) {
                Object object = resultSet.getObject(i);
                dataList.add(object == null ? "" : object.toString());
            }
            printWriter.println(convertListToString(dataList));
            dataList.clear();
        }
    }

    private int writeFileHead(ResultSet resultSet, PrintWriter printWriter) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        int size = metaData.getColumnCount();
        if (size == 0)
            throw new RuntimeException("cannot find any column");
        List<String> columnList = new ArrayList<String>(size);
        for (int i = 1; i <= size; i++) {
            columnList.add(metaData.getColumnName(i));
        }
        printWriter.println(convertListToString(columnList));
        return size;
    }


    private String convertListToString(List<String> dataList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String data : dataList) {
            stringBuilder.append(SEPARATOR).append("\"").append(data).append("\"");
        }
        return stringBuilder.substring(1);
    }

    public static void main(String[] args) {
        ExportDataToCSV export = new ExportDataToCSV();
        export.export("student");
    }
}
