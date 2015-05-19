package com.oukongli.util;

import java.sql.*;
import java.util.Properties;

/**
 * Created by ou_kongli on 2015/4/16.
 */
public class DBUtil {
    public static Connection getConnection() {
        Properties properties = PropertiesUtil.getJdbcProp();

        /*String username = "root";
        String password = "";
        String url = "jdbc:mysql://127.0.0.1:3306/store_oukongli?characterEncoding=UTF-8";*/

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String jdbcDrive = properties.getProperty("driver");
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void close(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(PreparedStatement ps) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet resultSet) {
        try {
            if(resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
