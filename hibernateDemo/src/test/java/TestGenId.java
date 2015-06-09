import model.Book;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

/**
 * Created by ou_kongli on 2015/6/9.
 */
public class TestGenId {
    @Test
    public void testAssigned() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Book book = new Book();
            book.setName("java");
            book.setPrice(100);
            session.save(book);//此时id为0，第二次运行报错
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }
}
