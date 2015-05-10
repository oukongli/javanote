package com.oukongli.dao;

import com.oukongli.model.Address;
import com.oukongli.model.Pager;

import java.util.List;

/**
 * Created by ou_kongli on 2015/5/5.
 */
public interface IAddressDao {
    public void add(Address address, int userId);
    public void update(Address address);
    public void delete(int id);
    public Address load(int id);
    public List<Address> list(int userId);
}
