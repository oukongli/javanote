package mongoDBTest;

import java.net.UnknownHostException;

/**
 * Created by kouyang on 12/14/2015.
 */
public class MongoDBJDBC implements App{
    public void run() {
        try {
            JDBCUtil.connectMongoDB();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
