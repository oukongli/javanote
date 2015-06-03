import model.User;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

import java.util.Date;

/**
 * Created by ou_kongli on 2015/6/3.
 */
public class TestHibernateStatus {
    @Test
    public void testTransient() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            User user = new User();
            user.setUsername("test user");
            user.setNickname("test nickname");
            user.setPassword("12345");
            user.setBorn(new Date());
            //以上是Transient，未被session管理，且db中没有
            //save之后，被session管理，且db中存在，此时是Persistent状态
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
    public void testPersistent() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            User user = new User();
            user.setUsername("testPersistent user");
            user.setNickname("testPersistent nickname");
            user.setPassword("12345");
            user.setBorn(new Date());
            session.save(user);
            user.setNickname("update name"); //有效  此时，user为persistent管理，当commit的时候，把session中的对象和当前对象作比较，若发生改变，则做update操作

            user.setPassword("000");
            session.save(user); //没有意义
            user.setUsername("oukongli");
            session.update(user); //没有意义

            session.getTransaction().commit();//总共执行2次sql
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
    public void testPersistent2() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            User user = new User();
            String s1 = new String("123");
            String s2 = new String("123");
            user.setUsername("testPersistent user");
            user.setNickname("testPersistent nickname");
            user.setPassword(s1);
            user.setBorn(new Date());
            session.save(user);
            user.setPassword(s2);
            session.save(user); //没有意义
            session.update(user); //没有意义

            session.getTransaction().commit();//总共执行1次sql
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
    public void testPersistent3() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            User u = (User) session.load(User.class, 8);
            u.setNickname("load");
            session.getTransaction().commit();//总共执行2次sql: select & update
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
    public void testDetach() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            User u = new User();
            u.setId(1);
            session.save(u);//save会执行插入，指定id无用
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
}
