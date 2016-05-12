import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String keyFormat = "N6%%%%%1$s@j%2$s";
        Set<String> cSet = new HashSet<String>() {{
            add("c");
            add("C");
        }};
        Set<String> oSet = new HashSet<String>() {{
            add("0");
            add("O");
            add("o");
        }};

        for (String c : cSet) {
            for (String o : oSet) {
                System.out.println(String.format(keyFormat, c, o));
            }
        }

    }
}
