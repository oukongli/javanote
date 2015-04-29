package com.shdev.oukongli.dao;

import com.shdev.oukongli.model.Message;
import com.shdev.oukongli.model.Pager;
import com.shdev.oukongli.model.ShopException;
import com.shdev.oukongli.model.SystemContext;
import com.shdev.oukongli.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ou_kongli on 2015/4/25.
 */
public class MessageDaoImpl implements IMessageDao {
    private IUserDao userDao;

    public MessageDaoImpl() {
        userDao = DAOFactory.getUserDao();
    }

    public void add(Message msg, int userId) {
        Connection con = null;
        PreparedStatement ps = null;
        if (userDao.load(userId) == null) {
            throw new ShopException("添加留言的用户不存在");
        }
        con = DBUtil.getConnection();
        String sql = "insert into t_msg(title, content, post_date, user_id) values (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, msg.getTitle());
            ps.setString(2, msg.getContent());
            ps.setTimestamp(3, new Timestamp(msg.getPostDate() == null ? new Date().getTime() : msg.getPostDate().getTime()));
            ps.setInt(4, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(ps);
            DBUtil.close(con);
        }
    }

    public void update(Message msg) {
        Connection con = null;
        PreparedStatement ps = null;
        con = DBUtil.getConnection();
        String sql = "update t_msg set title = ?, content = ? where id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, msg.getTitle());
            ps.setString(2, msg.getContent());
            ps.setInt(3, msg.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(ps);
            DBUtil.close(con);
        }
    }

    public void delete(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        con = DBUtil.getConnection();
        String sql = "delete from t_msg WHERE id = ?";
        try {
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

    public Message load(int id) {
        Message message = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = DBUtil.getConnection();
        String sql = "SELECT * from t_msg WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                message = new Message();
                message.setTitle(rs.getString("title"));
                message.setContent(rs.getString("content"));
                message.setId(rs.getInt("id"));
                message.setPostDate(new Date(rs.getTimestamp("post_date").getTime()));
                message.setUserId(rs.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }
        return message;
    }

    public Pager<Message> list() {
        Pager<Message> pages = new Pager<Message>();
        List<Message> messages = new ArrayList<Message>();
        pages.setDatas(messages);
        Message message = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = DBUtil.getConnection();
        int pageOffSet = SystemContext.getPageOffSet();
        int pageSize = SystemContext.getPageSize();
        int totalRecord = 0;
        pages.setPageOffSet(pageOffSet);
        pages.setPageSize(pageSize);
        String sqlCount = "select count(*) from t_msg";
        String sql = "SELECT * from t_msg order by post_date DESC limit ?, ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pageOffSet);
            ps.setInt(2, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                message = new Message();
                message.setTitle(rs.getString("title"));
                message.setContent(rs.getString("content"));
                message.setId(rs.getInt("id"));
                message.setPostDate(new Date(rs.getTimestamp("post_date").getTime()));
                message.setUserId(rs.getInt("user_id"));
                messages.add(message);
            }
            ps = con.prepareStatement(sqlCount);
            rs = ps.executeQuery();
            while (rs.next()) {
                totalRecord = rs.getInt(1);
                pages.setTotalRecord(totalRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }

        return pages;
    }
}
