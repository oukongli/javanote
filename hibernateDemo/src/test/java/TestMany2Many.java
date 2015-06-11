import model.Admin;
import model.Role;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

import java.util.HashSet;

/**
 * Created by ou_kongli on 2015/6/11.
 */
public class TestMany2Many {
    /**
     *  过于麻烦
     *  最佳实践：将多对多的关系拆分为2个一对多
     */
    @Test
    public void testAssigned() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Admin admin1 = new Admin();
            admin1.setName("1111");
            Admin admin2 = new Admin();
            admin2.setName("2222");
            session.save(admin1);
            session.save(admin2);

            final Role role1 = new Role();
            role1.setName("administrator");
            session.save(role1);

            final Role role2 = new Role();
            role2.setName("guest");
            session.save(role2);

            admin1.setRoles(new HashSet<Role>() {
                {
                    add(role1);
                }
            });
            admin2.setRoles(new HashSet<Role>() {
                {
                    add(role1);
                    add(role2);
                }
            });
            session.save(admin1);
            session.save(admin2);

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }



    @Test
    public void testload() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            Admin admin = (Admin) session.load(Admin.class, 1);
            System.out.println(admin.getName());
            System.out.println(admin.getRoles().size());
            System.out.println(admin.getRoles().iterator().next().getName());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }



}
