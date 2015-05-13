import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by ou_kongli on 2015/5/13.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAnnotation {
    String a() default "a";
    String b() default "b";
    String value() default "";
}
