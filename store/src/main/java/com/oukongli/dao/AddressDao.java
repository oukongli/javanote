package com.oukongli.dao;

import com.oukongli.model.Address;
import com.oukongli.util.DBUtil;

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

    }

    public void delete(int id) {

    }

    public Address address() {
        return null;
    }

    public List<Address> list(int userId) {


        return null;
    }
}
