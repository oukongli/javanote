package shdev.oukongli;

/**
 * Created by oukongli on 2015/1/19.
 */
public class TestRegex1 {
    public static void main(String[] args) {
        System.out.println("a".matches("."));
        System.out.println("aa".matches("."));
        System.out.println("aa".matches(".a"));
        System.out.println("12".matches("\\d\\d"));
        System.out.println("1f32e".matches("\\d\\D\\d\\d\\D"));

        System.out.println("D".matches("[^abcd]"));
        System.out.println("d".matches("[a-d]"));

        System.out.println("k".matches("[a-dh-l]"));
        System.out.println("k".matches("[a-d[h-l]]"));

        System.out.println("H".matches("[A-Z&&[IJK]]"));

    }
}
