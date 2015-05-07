import com.oukongli.dao.DAOFactory;
import com.oukongli.dao.IUserDao;
import com.oukongli.model.Pager;
import com.oukongli.model.SystemContext;
import com.oukongli.model.User;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ou_kongli on 2015/5/6.
 */


public class TestUserDao {
    private IUserDao userDao;

    @Before
    public void init() {
        userDao = DAOFactory.getUserDao();
    }

    @Test
    public void testAdd() {
        User user = new User();
        user.setUsername("test username");
        user.setNickname("test nickname");
        user.setPassword("test password");
        userDao.add(user);
    }

    @Test
    public void testUpdate() {
        User u = userDao.load(1);
        u.setUsername("admin");
        u.setPassword("admin");
        userDao.update(u);
    }

    @Test
    public void testDelete() {
        userDao.delete(7);
    }

    @Test
    public void testFind() {
        SystemContext.setPageOffSet(0);
        SystemContext.setPageSize(10);
        Pager<User> ps = userDao.find("u");
        System.out.println(ps.getDatas().size());
    }
}