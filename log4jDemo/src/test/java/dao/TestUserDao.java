package dao;

import org.junit.Test;
import service.UserService;

/**
 * Created by kouyang on 6/19/2015.
 */
public class TestUserDao {
    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            new UserDao().add();
            new UserService().add();
        }
    }
}
