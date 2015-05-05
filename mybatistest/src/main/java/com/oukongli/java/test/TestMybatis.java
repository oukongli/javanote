package com.oukongli.java.test;

import com.oukongli.java.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ou_kongli on 2015/5/5.
 */
public class TestMybatis {
    public static void main(String[] args) throws IOException {
        testUpdate();
    }

    public static void testAdd() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        User u = new User();
        u.setNickname("nickname");
        u.setUsername("username");
        u.setType(1);
        u.setPassword("password");
        sqlSession.insert("com.oukongli.java.model.User.add", u);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void testUpdate() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        User u = new User();
        u.setId(3);
        u.setNickname("nickname");
        u.setUsername("username");
        u.setType(1);
        u.setPassword("333333");
        sqlSession.update("com.oukongli.java.model.User.update", u);
        sqlSession.commit();
        sqlSession.close();
    }

}
