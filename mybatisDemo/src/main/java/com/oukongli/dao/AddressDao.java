package com.oukongli.dao;

import com.oukongli.mapper.AddressMapper;
import com.oukongli.model.Address;
import com.oukongli.model.Pager;
import com.oukongli.model.SystemContext;
import com.oukongli.util.DBUtil;
import com.oukongli.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ou_kongli on 2015/5/5.
 */
public class AddressDao implements IAddressDao {
    public void add(Address address, int userId) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            String sql = "insert into t_address(name, phone, postcode,user_id) VALUES (?, ?, ?, ?)";
            con = DBUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, address.getName());
            ps.setString(2, address.getPhone());
            ps.setString(3, address.getPostcode());
            ps.setInt(4, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(ps);
            DBUtil.close(con);
        }
    }

    public void update(Address address) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        AddressMapper addressMapper;
        try {
            addressMapper = sqlSession.getMapper(AddressMapper.class);
            addressMapper.update(address);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }
    }

    public void delete(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        AddressMapper addressMapper;
        try {
            addressMapper = sqlSession.getMapper(AddressMapper.class);
            addressMapper.delete(id);
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }
    }

    public Address load(int id) {
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        AddressMapper addressMapper;
        Address address;
        try {
            addressMapper = sqlSession.getMapper(AddressMapper.class);
            address = addressMapper.load(id);
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }
        return address;
    }

    public List<Address> list(int userId) {
        List<Address> addresses = new ArrayList<Address>();
        SqlSession sqlSession = MybatisUtil.createSqlSession();
        AddressMapper addressMapper;
        try {
            addressMapper = sqlSession.getMapper(AddressMapper.class);
            addresses = addressMapper.find(userId);
        } finally {
            MybatisUtil.closeSession(sqlSession);
        }
        return addresses;
    }
}
