package escape;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Created by kouyang on 12/17/2015.
 */
public class EscapeString {
    public static void main(String[] args) {
//        String test = "123\"string is ' string \"";
//        String xpath = "test @path=\"#{}\"";
//
//        String result = xpath.replace("#{}", test);
//
//        System.out.println(result);
//        System.out.println(xpath.replace("#{}", StringEscapeUtils.escapeXml11(test)));
        String s1 = "123";
        String s2 = "123";
        s2 = "234";
        s2 = "123";
        System.out.println(s1 == s2);
    }
}
