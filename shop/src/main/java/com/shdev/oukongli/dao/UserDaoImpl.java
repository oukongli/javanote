package com.shdev.oukongli.dao;

import com.shdev.oukongli.model.Pager;
import com.shdev.oukongli.model.ShopException;
import com.shdev.oukongli.model.SystemContext;
import com.shdev.oukongli.model.User;
import com.shdev.oukongli.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ou_kongli on 2015/4/16.
 */
public class UserDaoImpl implements IUserDao {
    public void add(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBUtil.getConnection();
            String sql = "select count(*) from t_user where username=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt(1) > 0) {
                    throw new ShopException("用户已存在");
                }
            }
            sql = "INSERT INTO t_user(id, username, password, nickname)  VALUES (null, ?, ?, ?)";
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNickname());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }
    }

    public void delete(int id) {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;

        try {
            con = DBUtil.getConnection();
            String sql = "delete from t_user where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(ps);
            DBUtil.close(con);
        }
    }

    public void update(User user) {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;

        try {
            con = DBUtil.getConnection();
            String sql = "update t_user set password = ?, nickname = ? WHERE id = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getNickname());
            ps.setInt(3, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(ps);
            DBUtil.close(con);
        }
    }

    public User load(int id) {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            con = DBUtil.getConnection();
            String sql = "select * from t_user where id = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setNickname(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }
        return user;
    }

    public Pager<User> list(String condition, int pageSize, int pageIndex) {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        int pageOffSet = SystemContext.getPageOffSet();
        pageSize = SystemContext.getPageSize();
        ResultSet rs = null;
        List<User> users = new ArrayList<User>();
        Pager<User> userPager = new Pager<User>();
        User user = null;
        int totalRecord = 0;
        try {
            con = DBUtil.getConnection();
            String sql = "select * from t_user";
            String sqlCount = "select count(*) from t_user";
//            if (pageIndex < 1)
//                pageIndex = 1;
//            int startIndex = (pageIndex - 1) * pageSize;
            if (condition == null || condition.equals("")) {
                sql += " limit ?,?";
                ps = con.prepareStatement(sql);
//                ps.setInt(1, startIndex);
                ps.setInt(1, pageOffSet);
                ps.setInt(2, pageSize);
            } else {
                sql += " where username like ? or nickname like ? limit ?,?";
                sqlCount += " where username like \'%" + condition + "%\' or nickname like \'%" + condition + "%\'";
                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + condition + "%");
                ps.setString(2, "%" + condition + "%");
//                ps.setInt(3, startIndex);
                ps.setInt(3, pageOffSet);
                ps.setInt(4, pageSize);
            }

            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setNickname(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }

            ps = con.prepareStatement(sqlCount);
            rs = ps.executeQuery();
            while (rs.next()) {
                totalRecord = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }
        userPager.setDatas(users);
        userPager.setTotalRecord(totalRecord);
        userPager.setPageIndex(pageIndex);
        userPager.setPageSize(pageSize);
        return userPager;
    }

    public User login(String username, String password) {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            con = DBUtil.getConnection();
            String sql = "select * from t_user where username = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setNickname(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
            }
            if (user == null) {
                throw new ShopException("用户不存在");
            }
            if (!user.getPassword().equals(password)) {
                throw new ShopException("密码不正确");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }
        return user;
    }
}
