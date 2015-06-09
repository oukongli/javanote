import model.User;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

/**
 * Created by ou_kongli on 2015/6/9.
 */
public class TestLazy {
    @Test
    public void testLazy() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            User user = (User)session.load(User.class, 5);
            //此时不会立即执行sql语句,只有使用时才会执行sql
            //load之后，user是一个代理对象，仅存在id

            User user1 = (User) session.get(User.class, 6);//会执行sql


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }

    }

    @Test
    public void testLazy2() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            User user = (User)session.load(User.class, 5);
            System.out.println(user.getId());//不会执行sql  代理对象user存在id
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

    @Test
    public void testLazy3() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            User user = (User)session.get(User.class, 50);//不存在
//            System.out.println(user.getId());// 空指针异常

            User user1 = (User)session.load(User.class, 51);//不存在
            System.out.println(user1.getId());//51
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }

    }

    @Test
    public void testLazy4() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            User user1 = (User)session.load(User.class, 51);//不存在
            System.out.println(user1.getId());//51

            System.out.println(user1.getNickname());//ObjectNotFoundException
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }

    }

    @Test
    public void testLazyProblem() {

        User user = getUser();
        user.getNickname();//报错，此时session已关闭,而sql还未执行

    }

    private User getUser() {
        Session session = null;
        User user = null;

        try {
            session = HibernateUtil.getSession();
            user = (User) session.load(User.class, 5);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }

        return user;
    }

}
