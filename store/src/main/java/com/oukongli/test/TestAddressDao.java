package com.oukongli.test;

import com.oukongli.dao.DAOFactory;
import com.oukongli.dao.IAddressDao;
import com.oukongli.model.Address;

/**
 * Created by ou_kongli on 2015/5/5.
 */
public class TestAddressDao {
    private static IAddressDao addressDao = DAOFactory.getAddressDao();

    public static void main(String[] args) {
        testAddAddress();
    }

    private static void testAddAddress() {
        Address address = new Address();
        address.setName("shang hai");
        address.setPostcode("123456");
        address.setPhone("110");
        addressDao.add(address, 1);
    }
}
