package shdev.oukongli.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by oukongli on 2015/2/5.
 */
public class TestJDBC2 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;

        String url = "jdbc:mysql://localhost:3306/shdev_oukongli_test";
        String user = "root";
        String password = "";
        try {
            //使用prepareStatement可有效防止sql注入
            con = DriverManager.getConnection(url, user, password);
            String sql = "select * from t_uer where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, 3);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
