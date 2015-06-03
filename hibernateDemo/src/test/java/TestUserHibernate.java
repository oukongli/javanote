import model.User;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

import java.util.Date;
import java.util.List;

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
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void testLoad() {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            User u = (User) session.load(User.class, 1);
            System.out.println(u.getId() + ":" + u.getNickname());
        } catch (Exception e) {

        } finally {
            HibernateUtil.closeSession(session);
        }
    }

    @Test
    public void testUpdate() {
        Session session =  null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            User u = (User) session.load(User.class, 1);
            u.setNickname("update name");
            session.update(u);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void testDelete() {
        Session session =  null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            User u = new User();
            u.setId(1);
            session.delete(u);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Test
    public void testList() {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            List<User> users = session.createQuery("from User")
                    .setFirstResult(1)
                    .setMaxResults(15)
                    .list();
            System.out.println(users.size());
        } catch (Exception e) {

        } finally {
            HibernateUtil.closeSession(session);
        }
    }
}
