package cal;


public class Outer {
    class Inner {

    }

    public static void main(String[] args) {
        new Outer().new Inner();
    }
}
