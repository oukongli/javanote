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
            //save之后，被session管理，且db中存在，此时是状态
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

    @Test
    public void testDetach2() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            User u = new User();
            u.setId(10);  //存在
            session.update(u);
            u.setNickname("10");
            u.setPassword("10");
            session.update(u);//一条sql
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
    public void testDetach3() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            User u = new User();
            u.setId(10);  //存在
            session.update(u);
            u.setNickname("10");
            u.setPassword("10");

            u.setId(100);//报错
            session.update(u);//一条sql
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
    public void testDetach4() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            User u = new User();
            u.setId(10);  //存在
            session.delete(u);//u变成transient

            u.setPassword("");
            session.update(u);//报错
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
    public void testDetach5() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            User user1 = (User)session.load(User.class, 10);//user1  Persistent
            System.out.println(user1.getNickname());
            User user2 = new User();
            user2.setId(10); //user2 Transient
            //报错
            session.saveOrUpdate(user2);  //报错，session中已有2个相同id, 此时用session.merge(user2);


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
