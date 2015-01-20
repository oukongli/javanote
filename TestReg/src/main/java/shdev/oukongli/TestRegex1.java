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


        System.out.println("0557-5090041".matches("\\d{4}-\\d{7}"));

        System.out.println("192.168.0.1".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));

        // ^在[]中和不在[]中不一样
        System.out.println("helloword".matches("^h.*"));
        // $ 表示以xx为结尾
        System.out.println("1you9u".matches("^\\d.*u$"));
    }
}
