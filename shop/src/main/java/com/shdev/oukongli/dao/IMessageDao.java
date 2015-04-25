package com.shdev.oukongli.dao;

import com.shdev.oukongli.model.Message;
import com.shdev.oukongli.model.Pager;

/**
 * Created by ou_kongli on 2015/4/25.
 */
public interface IMessageDao {
    public void add(Message msg, int userId);
    public void update(Message msg);
    public void delete(int id);
    public Message load(int id);
    public Pager<Message> list();
}
