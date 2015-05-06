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
        testAdd();
        testUpdate();
        testDelete();
        testLoad();
    }

    public static void testLoad() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        User u = sqlSession.selectOne(User.class.getName() + ".load", 1);
        System.out.println(1);
        MybatisUtil.closeSession(sqlSession);
    }

    public static void testAdd() throws IOException {
        SqlSession sqlSession = getSqlSession();
        User u = new User();
        u.setId(3);
        u.setNickname("nickname");
        u.setUsername("username");
        u.setType(1);
        u.setPassword("password");
        sqlSession.insert("com.oukongli.java.model.User.add", u);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void testUpdate() throws IOException {

        SqlSession sqlSession = getSqlSession();
        User u = new User();
        u.setId(3);
        u.setNickname("nickname");
        u.setUsername("username");
        u.setType(1);
        u.setPassword("333333");
        sqlSession.update(User.class.getName() + ".update", u);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void testDelete() {
        SqlSession sqlSession = getSqlSession();
        sqlSession.update(User.class.getName() + ".delete", 3);
        sqlSession.commit();
        sqlSession.close();
    }


    private static SqlSession getSqlSession() {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
       return factory.openSession();
    }

}
