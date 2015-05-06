package com.oukongli.dao;

/**
 * Created by ou_kongli on 2015/5/5.
 */
public class DAOFactory {
    public static IAddressDao getAddressDao() {
        return new AddressDao();
    }

    public static IUserDao getUserDao() {
        return new UserDao();
    }
}
