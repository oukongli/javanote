import model.Course;
import model.Teacher;
import model.TeacherCourse;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

/**
 * Created by ou_kongli on 2015/6/12.
 */
public class TestMany2ManyToOne2Many {
    /**
     * 最佳实践，不使用双向关联
     */
    @Test
    public void testAssigned() {
        Session session = null;

        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            Teacher teacher1 = new Teacher();
            Teacher teacher2 = new Teacher();
            teacher1.setName("老刘");
            teacher2.setName("老张");
            session.save(teacher1);
            session.save(teacher2);

            Course course1 = new Course();
            Course course2 = new Course();
            course1.setName("数据结构");
            course2.setName("计算机网络");
            session.save(course1);
            session.save(course2);

            TeacherCourse teacherCourse1 = new TeacherCourse();
            teacherCourse1.setAch(100);
            teacherCourse1.setCourse(course1);
            teacherCourse1.setTeacher(teacher1);
            session.save(teacherCourse1);

            TeacherCourse teacherCourse2 = new TeacherCourse();
            teacherCourse2.setAch(95);
            teacherCourse2.setCourse(course2);
            teacherCourse2.setTeacher(teacher1);
            session.save(teacherCourse2);

            TeacherCourse teacherCourse3 = new TeacherCourse();
            teacherCourse3.setAch(100);
            teacherCourse3.setCourse(course1);
            teacherCourse3.setTeacher(teacher2);
            session.save(teacherCourse3);

            TeacherCourse teacherCourse4 = new TeacherCourse();
            teacherCourse4.setAch(95);
            teacherCourse4.setCourse(course2);
            teacherCourse4.setTeacher(teacher2);
            session.save(teacherCourse4);


            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

}
