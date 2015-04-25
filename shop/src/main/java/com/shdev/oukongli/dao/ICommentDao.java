package com.shdev.oukongli.dao;

import com.shdev.oukongli.model.Comment;
import com.shdev.oukongli.model.Pager;

/**
 * Created by ou_kongli on 2015/4/25.
 */
public interface ICommentDao {
    public void add(Comment comment, int userId, int msgId);
    public void delete(int id);
    public Comment load(int id);
    public Pager<Comment> list(int msgId);
}
