import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by ou_kongli on 2015/5/13.
 */
public class TestUser {
    @UserAnnotation(b = "456", value = "123")
    public void testUser() {

    }

    @UserAnnotation
    public void setUser() {

    }

    @Test
    public void test1() {
        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + ":" + method.isAnnotationPresent(UserAnnotation.class));
            if (method.isAnnotationPresent(UserAnnotation.class)) {
                UserAnnotation annotation = (UserAnnotation)method.getAnnotation(UserAnnotation.class);
                String v = annotation.value();
                if (StringUtils.EMPTY.equals(v)) {
                    v = method.getName().substring(3);
                }
                System.out.println(v);
            }
        }
    }
}

