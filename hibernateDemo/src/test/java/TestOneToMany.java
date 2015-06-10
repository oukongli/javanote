import model.Classroom;
import model.Comment;
import model.Message;
import model.Student;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

import java.util.HashSet;

/**
 * Created by ou_kongli on 2015/6/10.
 */
public class TestOneToMany {
    @Test
    public void testAdd() {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            final Comment comment1 = new Comment();
            comment1.setContent("comment1");
            final Comment comment2 = new Comment();
            comment2.setContent("comment2");

            Message message = new Message();
            message.setContent("message");
            message.setTitle("title");
            message.setComments(new HashSet<Comment>() {
                {
                    add(comment1);
                    add(comment2);
                }
            });
            session.save(comment1);
            session.save(comment2);
            session.save(message);
            session.getTransaction().commit();//5条sql
            //开发中不建议使用one2many的单向
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

            Message message = (Message) session.load(Message.class, 1);//comments 延迟加载
            System.out.println(message.getContent());
            System.out.println(message.getComments().size());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

    @Test
    public void testAdd2() {
        Session session = null;
        try {
            session = HibernateUtil.getSession();
            session.beginTransaction();

            final Student student1 = new Student();
            student1.setName("stu1");
            final Student student2 = new Student();
            student1.setName("stu2");

            Classroom classroom = new Classroom();
            classroom.setName("shuxue");
            classroom.setStudents(new HashSet<Student>() {
                {
                    add(student1);
                    add(student2);
                }
            });
            session.save(student1);
            session.save(student2);
            session.save(classroom);
            session.getTransaction().commit();//5条sql
            //开发中不建议使用one2many 的 one来维护关系
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            HibernateUtil.closeSession(session);
        }
    }

}
