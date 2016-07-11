package com.shdev.demo;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by ou_ko on 2016/7/11.
 */
public class DBManager4Mysql {
    private static final Logger logger = Logger.getLogger(DBManager4Mysql.class);
    private static final String mysqlDBConfigFile = "mysql.dbcp.properties";
    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        try {
            properties.load(DBManager4Mysql.class.getClassLoader().getResourceAsStream(mysqlDBConfigFile));
            dataSource = BasicDataSourceFactory.createDataSource(properties);
            logger.info("databasepool init success!");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}
