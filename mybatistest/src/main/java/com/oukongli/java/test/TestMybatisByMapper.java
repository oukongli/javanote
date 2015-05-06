package com.oukongli.java.test;

import com.oukongli.java.mapper.UserMapper;
import com.oukongli.java.model.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ou_kongli on 2015/5/6.
 */
public class TestMybatisByMapper {
    @Test
    public void TestAdd() {
        SqlSession sqlSession = null;

        sqlSession = MybatisUtil.getSqlSession();
        User u = new User();
        u.setId(3);
        u.setNickname("nickname");
        u.setUsername("username");
        u.setType(1);
        u.setPassword("password");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.add(u);
        sqlSession.commit();

        User user = userMapper.load(3);
        Assert.assertEquals(u.getId(), user.getId());
        Assert.assertEquals(u.getUsername(), user.getUsername());
        Assert.assertEquals(u.getNickname(), user.getNickname());
        Assert.assertEquals(u.getPassword(), user.getPassword());
        Assert.assertEquals(u.getType(), user.getType());

        userMapper.delete(u.getId());
        sqlSession.commit();
    }
}
