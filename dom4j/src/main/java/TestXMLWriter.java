import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by oukongli on 2015/1/22.
 */
public class TestXMLWriter {
    public static void main(String[] args) {
        XMLWriter out = null;
        try {
            Document document = DocumentHelper.createDocument();
            Element root = document.addElement("users");
            root.addAttribute("id","1");
            root.addElement("user").addElement("name").addText("test1");
            String path = ".\\src\\main\\resources\\user.xml";
            root.addElement("user").addText("test2");
            out = new XMLWriter(new FileWriter(path), OutputFormat.createPrettyPrint());
            out.write(document);
            System.out.println(path);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null)
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
