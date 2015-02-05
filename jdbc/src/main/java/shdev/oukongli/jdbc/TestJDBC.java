package shdev.oukongli.jdbc;

import jdk.nashorn.internal.objects.NativeUint16Array;

import java.sql.*;

/**
 * Created by oukongli on 2015/2/5.
 */
public class TestJDBC {
    public static void main(String[] args){
        Connection con = null;
        Statement state = null;
        ResultSet rs = null;
        try {
            //创建connection
            String url = "jdbc:mysql://localhost:3306/shdev_oukongli_test";
            String user = "root";
            String password = "";
            con = DriverManager.getConnection(url, user, password);

            //创建sql
            String sql = "select * from t_user";
            state = con.createStatement();

            rs = state.executeQuery(sql);

            //遍历结果集
            while(rs.next()) {
                //rs.getInt("id");
                //rs.getString("name");
                //rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //先释放rs，其次是state，最后是con
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (state != null)
                    state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
