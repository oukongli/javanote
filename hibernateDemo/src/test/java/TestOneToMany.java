import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

/**
 * Created by ou_kongli on 2015/6/10.
 */
public class TestOneToMany {
    @Test
    public void testAdd() {
        Session session = null;
        try {

            //×î¼ÑÊµ¼ù£¬ÏÈ´æforeign key
            session = HibernateUtil.getSession();
            session.beginTransaction();



            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }
}
