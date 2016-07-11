package com.shdev.demo;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ou_ko on 2016/7/12.
 */
public class DBManager {
    private static final Logger logger = Logger.getLogger(DBManager.class);

    public static void releaseConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void closeStatement(Statement stm, ResultSet result) {
        try {
            if (result != null) {
                result.close();
            }
        } catch (SQLException e) {
            logger.error("closeResultSet error:", e);
            e.printStackTrace();
        }

        try {
            if (stm != null) {
                stm.close();
            }
        } catch (SQLException e) {
            logger.error("closeStatement error:", e);
            e.printStackTrace();
        }
    }

    public static void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                logger.error("close Statement error", e);
                e.printStackTrace();
            }
        }
    }
}
