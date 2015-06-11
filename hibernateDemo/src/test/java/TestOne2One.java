import model.IDCard;
import model.Person;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

/**
 * Created by ou_kongli on 2015/6/11.
 */
public class TestOne2One {
    @Test
    public void test1() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Person person = new Person();
            person.setName("person1");
            session.save(person);

            IDCard idCard = new IDCard();
            idCard.setNo("000000");
            idCard.setPerson(person);
            session.save(idCard);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.closeSession(session);
        }

    }

    @Test
    public void test2() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Person person = (Person) session.load(Person.class, 1);

            IDCard idCard = new IDCard();
            idCard.setNo("1111");
            idCard.setPerson(person);
            session.save(idCard);
            session.getTransaction().commit();//报错,与test1（）conflict
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

    @Test
    public void test3() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            IDCard idCard = new IDCard();
            idCard.setNo("123456789");
            session.save(idCard);
            Person person = new Person();
            person.setName("testName");
            person.setIdCard(idCard);
            session.save(person);
            session.getTransaction().commit();
            /**
             * idcard（fk），此时person.setIdCard(idCard);无效
             *
             * 应改为test4()
             */
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }


    @Test
    public void test4() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            Person person = new Person();
            person.setName("testName");
            session.save(person);
            IDCard idCard = new IDCard();
            idCard.setNo("1234567890");
            idCard.setPerson(person);
            session.save(idCard);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }


    @Test
    public void testload1() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();

            Person person = (Person) session.load(Person.class, 1);
            System.out.println(person.getName());
            System.out.println(person.getIdCard().getNo());   //一条sql

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }


    @Test
    public void testload2() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();

            IDCard idCard = (IDCard) session.load(IDCard.class, 1);
            System.out.println(idCard.getNo());
            System.out.println(idCard.getPerson().getName());  //3条sql

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

    //最佳实践: 不要使用双向one2one
}
