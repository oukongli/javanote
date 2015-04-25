package com.shdev.oukongli.dao;

/**
 * Created by ou_kongli on 2015/4/16.
 */
public class DAOFactory {
   public static IUserDao getUserDao() {
       return new UserDaoImpl();
   }

    public static IMessageDao getMessageDao() {
        return new MessageDaoImpl();
    }

    public static ICommentDao getCommentDao() {
        return new CommentDaoImpl();
    }
}
