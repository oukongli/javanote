import model.User;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

import java.util.Date;

/**
 * Created by ou_kongli on 2015/6/2.
 */
public class TestUserHibernate {

    @Test
    public void testAdd() {
        Session session =  null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            User user = new User();
            user.setUsername("test user");
            user.setNickname("test nickname");
            user.setPassword("12345");
            user.setBorn(new Date());
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
