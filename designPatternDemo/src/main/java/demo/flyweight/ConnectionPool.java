package demo.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Created by kouyang on 6/5/2015.
 */
public class ConnectionPool {
    private Vector<Connection> pool;

    private String url = "jdbc:mysql://localhost:3306/test";
    private String username = "root";
    private String password = "#Bugsfor$";
    private String driveClassName = "com.mysql.jdbc.Driver";

    private int poolSize = 100;
    private static ConnectionPool instance = null;
    Connection conn = null;

    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    private ConnectionPool() {
        pool = new Vector<Connection>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            try {
                Class.forName(driveClassName);
                conn = DriverManager.getConnection(url, username, password);
                pool.add(conn);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void release(Connection conn) {
        pool.add(conn);
    }

    public synchronized Connection getConnection() {
        if (pool.size() > 0) {
            Connection connection = pool.get(0);
            pool.remove(connection);
            return connection;
        } else {
            return null;
        }
    }
}
