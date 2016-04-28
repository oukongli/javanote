package mongoDBTest;

import com.mongodb.DB;
import com.mongodb.MongoClient;

import java_cup.shift_action;

import java.net.UnknownHostException;

/**
 * Created by kouyang on 12/14/2015.
 */
public class JDBCUtil {

    private JDBCUtil() {
    }

    private static final String HOST = "10.88.48.10";

    private static final String TE_STRING="jk";
    
    public static void connectMongoDB() throws UnknownHostException {
        MongoClient client = new MongoClient(HOST, 27017);
        DB db = client.getDB("test");
        output("Connect to database successfully");
    }

    public static void output(String content) {
        System.out.println(content);
    }

}
