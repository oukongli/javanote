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
            //��ʱ��������ִ��sql���,ֻ��ʹ��ʱ�Ż�ִ��sql
            //load֮��user��һ��������󣬽�����id

            User user1 = (User) session.get(User.class, 6);//��ִ��sql


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
            System.out.println(user.getId());//����ִ��sql  �������user����id
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
            User user = (User)session.get(User.class, 50);//������
//            System.out.println(user.getId());// ��ָ���쳣

            User user1 = (User)session.load(User.class, 51);//������
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
            User user1 = (User)session.load(User.class, 51);//������
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
        user.getNickname();//������ʱsession�ѹر�,��sql��δִ��

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
