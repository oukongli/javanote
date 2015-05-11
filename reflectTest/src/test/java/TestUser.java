import com.shdev.oukongli.User;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * Created by ou_kongli on 2015/5/11.
 */
public class TestUser {
    @Test
    public void test1() {
        User user = new User(1, "user1");
        System.out.println(user);
    }

    @Test
    public void test2() {
        try {
            String obj = "com.shdev.oukongli.User";
            Class clazz = Class.forName(obj);
            User user = (User) clazz.newInstance();
            user.setId(2);
            user.setName("user2");
            System.out.println(user);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        try {
            String obj = "com.shdev.oukongli.User";
            Class clazz = Class.forName(obj);
            User user = (User) clazz.newInstance();
            user.setId(3);
            user.setName("user3");
            System.out.println(user);
            //通过反射调用方法
            String methodString = "getName";
            Method method = clazz.getMethod(methodString);
            String name = (String) method.invoke(user);
            System.out.println("name=" + name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
