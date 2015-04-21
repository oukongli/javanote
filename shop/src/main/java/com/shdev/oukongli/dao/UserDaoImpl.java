package com.shdev.oukongli.dao;

import com.shdev.oukongli.model.ShopException;
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
            sql = "INSERT INTO t_user VALUES (null, ?, ?, ?)";
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

    public List<User> list() {
        Connection con = DBUtil.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<User>();
        User user = null;
        try {
            con = DBUtil.getConnection();
            String sql = "select * from t_user";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setNickname(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }
        return users;
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
