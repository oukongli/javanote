package enumTests.enumtest2;

import java.util.Collection;

/**
 * Created by kouyang on 12/1/2015.
 */
public class EnumTest2 {
    public static void main(String[] args) {
        double x = 2;
        double y = 3;
        test(BasicOperation.class, x, y);
        test(ExtendedOperation.class, x, y);
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
        for (T t : opSet.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, t, y, t.apply(x, y));
        }
    }

    private static void test2(Collection<? extends Operation> opSet, double x, double y) {
        for (Operation t : opSet) {
            System.out.printf("%f %s %f = %f%n", x, t, y, t.apply(x, y));
        }

    }
}
