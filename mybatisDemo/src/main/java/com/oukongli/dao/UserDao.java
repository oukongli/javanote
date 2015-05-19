package com.oukongli.dao;

import com.oukongli.mapper.UserMapper;
import com.oukongli.model.Pager;
import com.oukongli.model.SystemContext;
import com.oukongli.model.User;
import com.oukongli.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ou_kongli on 2015/5/5.
 */
public class UserDao implements IUserDao {
    public User load(int userId) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        UserMapper userMapper;
        User user;
        try {
            userMapper = sqlSession.getMapper(UserMapper.class);
            user = userMapper.load(userId);
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }
        return user;
    }

    public void add(User user) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        UserMapper userMapper;
        try {
            userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.add(user);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }
    }

    public void update(User user) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        UserMapper userMapper;
        try {
            userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.update(user);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }
    }

    public Pager<User> find(String name) {
        int pageSize = SystemContext.getPageSize();
        int pageOffset = SystemContext.getPageOffSet();
        Pager<User> userPager = new Pager<User>();
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        UserMapper userMapper;
        try {
            userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> date = userMapper.find(name, pageOffset, pageSize);
            int total = userMapper.findcount(name);
            userPager.setDatas(date);
            userPager.setTotalPage(total);
            userPager.setPageOffSet(pageOffset);
            userPager.setPageSize(pageSize);
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }
        return userPager;
    }

    public void delete(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        UserMapper userMapper;
        try {
            userMapper = sqlSession.getMapper(UserMapper.class);
            userMapper.delete(id);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }
    }
}
