package com.shdev.oukongli.dao;

import com.shdev.oukongli.model.*;
import com.shdev.oukongli.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ou_kongli on 2015/4/25.
 */
public class CommentDaoImpl implements ICommentDao {
    private IUserDao userDao;
    private ICommentDao commentDao;

    public CommentDaoImpl() {
        userDao = DAOFactory.getUserDao();
        commentDao = DAOFactory.getCommentDao();
    }

    public void add(Comment comment, int userId, int msgId) {
        Connection con = null;
        PreparedStatement ps = null;
        con = DBUtil.getConnection();
        String sql = "insert into t_comment(content, post_date, user_id, msg_id) values (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, comment.getContent());
            ps.setTimestamp(2, new Timestamp(comment.getPostDate() == null ? new Date().getTime() : comment.getPostDate().getTime()));
            ps.setInt(3, userId);
            ps.setInt(4, msgId);
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
        String sql = "delete from t_comment WHERE id = ?";
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

    public Comment load(int id) {
        Comment comment = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = DBUtil.getConnection();
        String sql = "SELECT * from t_comment WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                comment = new Comment();
                comment.setContent(rs.getString("content"));
                comment.setId(rs.getInt("id"));
                comment.setPostDate(new Date(rs.getTimestamp("post_date").getTime()));
                comment.setUserId(rs.getInt("user_id"));
                comment.setUserId(rs.getInt("msg_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(rs);
            DBUtil.close(ps);
            DBUtil.close(con);
        }

        return comment;
    }

    public Pager<Comment> list(int msgId) {

        Pager<Comment> pages = new Pager<Comment>();
        List<Comment> comments = new ArrayList<Comment>();
        pages.setDatas(comments);
        Comment comment = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        con = DBUtil.getConnection();
        int pageOffSet = SystemContext.getPageOffSet();
        int pageSize = SystemContext.getPageSize();
        int totalRecord = 0;
        pages.setPageOffSet(pageOffSet);
        pages.setPageSize(pageSize);
        String sqlCount = "select count(*) from t_comment WHERE msg_id = ?";
        String sql = "SELECT * from t_comment WHERE msg_id = ? order by post_date limit ?, ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, msgId);
            ps.setInt(2, pageOffSet);
            ps.setInt(3, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                comment = new Comment();
                comment.setContent(rs.getString("content"));
                comment.setId(rs.getInt("id"));
                comment.setPostDate(new Date(rs.getTimestamp("post_date").getTime()));
                comment.setUserId(rs.getInt("user_id"));
                comment.setMsgId(msgId);
                comments.add(comment);
            }
            ps = con.prepareStatement(sqlCount);
            ps.setInt(1, msgId);
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
