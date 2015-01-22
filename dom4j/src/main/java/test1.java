import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * Created by oukongli on 2015/1/21.
 */
public class Test1 {
    public static void main(String[] args) throws DocumentException {

        /**
         * 要获取类路径下的文件可以通过类.class.getClassLoader().getResource(filename)得到
         */
        /*URL url =  Test1.class.getClassLoader().getResource("test.xml");
        File f = new File(url.getPath());
        System.out.println(f.exists());*/

        SAXReader reader = new SAXReader();
        Document document = reader.read(Test1.class.getClassLoader().getResourceAsStream("test.xml"));

        Element root = document.getRootElement();
        System.out.println(root.getName());

//        List<Element> eles = root.elements();
//        for (Element e : eles){
//            System.out.println(e.getName());
//            System.out.println(e.attributeValue("id"));
//            System.out.println(e.elementText("title"));
//        }

        /**
         * xpath的使用
         */
        //绝对路径
        List<Element> list = root.selectNodes("/books/book");

        for (Element e : list){
            System.out.println(e.elementText("title"));
        }

        list = root.selectNodes("/books/book[price>120]");

        for (Element e : list){
            System.out.println(e.elementText("title"));
        }
        //
    }
}
