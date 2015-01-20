package shdev.oukongli;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by oukongli on 2015/1/20.
 */
public class TestEmail {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("test.txt"));
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = br.readLine()) != null){
                sb.append(str);
            }
            for (String s : getEmail(sb.toString())){
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
    public static List<String> getEmail(String str){
        List<String> list = new ArrayList<String>();
        Pattern p = Pattern.compile("[\\w\\.-]*\\w+@[\\w\\.-]]*\\w+\\.\\w{2,5}");
        Matcher m = p.matcher(str);
        while (m.find()){
            list.add(m.group());
        }
        return list;
    }
}
