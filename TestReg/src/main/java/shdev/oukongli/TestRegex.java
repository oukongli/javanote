package shdev.oukongli;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by oukongli on 2015/1/20.
 */
public class TestRegex {
    public static void main(String[] args) {
        //将一个正则表达式编译成一个pattern对象可以提高效率
        Pattern p = Pattern.compile("\\d{4}");
        //通过pattern可以获取一个matcher对象，通过matcher对象可以获取大量有用的信息
        Matcher m = p.matcher("12345- -1934-12300 +++");

        //判断是否匹配
        System.out.println(m.matches());

        //重置m
        m.reset();
        //find指的是顺序匹配对应的字符串，可以将字符串通过group获取
        while (m.find()) {
            System.out.println(m.group() + "[" + m.start() + "," + m.end() + "]");
        }

        //replaceAll
        System.out.println("0557-5090041".replaceAll("\\d", "*"));
        System.out.println("0557-5090041".replaceAll("\\d+", "*"));
        System.out.println("0557-5090041".replaceAll("\\d{4}$", "****"));

        //是用括号进行分组
        String str = "342222198900000001,342222198900000002,342222198900000003";
        Pattern pattern = Pattern.compile("(\\d{6})(\\d{8})(\\d{4})");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println("生源地:" + matcher.group(1) + "日期" + matcher.group(2));
        }

        //贪婪模式匹配
        //结果为hello</td><td>world
        matcher = Pattern.compile("<td>(.*)</td>").matcher("<table><td>hello</td><td>world</td></table>");
        while (matcher.find()){
            System.out.println(matcher.group(1));
        }

        //非贪婪模式
        //?在*+之后表示使用了非贪婪模式
        matcher = Pattern.compile("<td>(.*?)</td>").matcher("<table><td>hello</td><td>world</td></table>");
        while (matcher.find()){
            System.out.println(matcher.group(1));
        }
    }
}
