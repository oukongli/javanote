package com.shdev.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ou_ko on 2016/7/11.
 */

public class TestDML {
    public static void main(String[] args) throws SQLException {
        insert();
//        move();
    }

    private static void select() throws SQLException {
        Connection connection = DBManager4Mysql.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT t.name, t.age, t.sex from student t", ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        preparedStatement.setFetchSize(Integer.MIN_VALUE);
        preparedStatement.setFetchDirection(ResultSet.FETCH_REVERSE);
        long start = System.currentTimeMillis();
        ResultSet resultSet = preparedStatement.executeQuery();
        System.out.println(resultSet.getFetchSize());
        long count = 0;
        while (resultSet.next()) {
            count++;
            if (count % 10000 == 0)
                System.out.println("name" + resultSet.getString("name") + resultSet.getString("sex"));
        }
        System.out.println((System.currentTimeMillis() - start) / 1000);
        DBManager.closeStatement(preparedStatement, resultSet);
        DBManager.releaseConnection(connection);
    }

    private static void delete() throws SQLException {
        Connection connection = DBManager4Mysql.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("delete from student");
        preparedStatement.execute();
        connection.commit();
        DBManager.closeStatement(preparedStatement);
        DBManager.releaseConnection(connection);
    }

    private static void insert() throws SQLException {
//        Connection connection = DBManager4Mysql.getConnection();
        Connection connection = DBManager4Oracle.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into student(name, age ,sex) values (?,?,?)");
        long start = System.currentTimeMillis();
        for (long i = 0; i < 9999999; i++) {
            preparedStatement.setString(1, "用户");
            preparedStatement.setInt(2, 50);
            preparedStatement.setString(3, "female");
            preparedStatement.addBatch();
            if (i % 5000 == 0) {
                preparedStatement.executeBatch();
            }
            if (i % 100000 == 0)
                connection.commit();
        }
        preparedStatement.executeBatch();
        connection.commit();
        System.out.println((System.currentTimeMillis() - start) / 1000);
        DBManager.closeStatement(preparedStatement);
        DBManager.releaseConnection(connection);
    }

    private static void move() throws SQLException {
        Connection mysqlConnection = DBManager4Mysql.getConnection();
        Connection oracleConnection = DBManager4Oracle.getConnection();
        PreparedStatement mysqlPreparedStatement = mysqlConnection.prepareStatement("SELECT t.name, t.age, t.sex from student t");
        PreparedStatement oraclePreparedStatement = oracleConnection.prepareStatement("insert into student(name, age ,sex) values (?,?,?)");
        long start = System.currentTimeMillis();
        ResultSet resultSet = mysqlPreparedStatement.executeQuery();
        long count = 0;
        while (resultSet.next()) {
            oraclePreparedStatement.setString(1, resultSet.getString("name"));
            oraclePreparedStatement.setInt(2, resultSet.getInt("age"));
            oraclePreparedStatement.setString(3, resultSet.getString("sex"));
            oraclePreparedStatement.addBatch();
            if (count++ % 5000 == 0)
                oraclePreparedStatement.executeBatch();
        }
        oraclePreparedStatement.executeBatch();
        oracleConnection.commit();
        System.out.println((System.currentTimeMillis() - start) / 1000);
        DBManager.closeStatement(mysqlPreparedStatement, resultSet);
        DBManager.releaseConnection(mysqlConnection);
        DBManager.closeStatement(oraclePreparedStatement);
    }
}
