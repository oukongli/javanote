package flyweight;

import demo.flyweight.ConnectionPool;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kouyang on 6/5/2015.
 */
public class TestConnectionPool {
    @Test
    public void testName() throws Exception {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Connection> connections = new ArrayList<Connection>();
        for (int i = 0; i < 100; i++) {
            Connection connection = connectionPool.getConnection();
            Assert.assertNotNull(connection);
            connections.add(connection);
        }
        Assert.assertNull(connectionPool.getConnection());
        for (Connection connection : connections) {
            connectionPool.release(connection);
        }
        Assert.assertNotNull(connectionPool.getConnection());
    }
}
