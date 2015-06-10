import model.Classroom;
import model.Student;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

/**
 * Created by ou_kongli on 2015/6/10.
 */
public class TestManyToOne {
    @Test
    public void testAdd() {
        Session session = null;
        try {

            //最佳实践，先存foreign key
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Classroom classroom = new Classroom();
            classroom.setGrade(2012);
            classroom.setName("jsj");
            session.save(classroom);
            Student student1 = new Student();
            student1.setName("stu1");
            student1.setNo("001");
            student1.setClassroom(classroom);
            session.save(student1);
            Student student2 = new Student();
            student2.setName("stu1");
            student2.setNo("001");
            student2.setClassroom(classroom);
            session.save(student2);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

    @Test
    public void testLoad() {
        Session session = null;
        try {
            session = HibernateUtil.getSession();

            Student student = (Student) session.load(Student.class, 1);//classroom 延迟加载
            System.out.println(student.getName());
            System.out.println(student.getClassroom().getName());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }
}
