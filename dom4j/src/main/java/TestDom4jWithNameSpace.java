import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ou_ko on 2016/7/26.
 */
public class TestDom4jWithNameSpace {
    public static void main(String[] args) throws DocumentException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("s", "uuid:BDC6E3F0-6DA3-11d1-A2A3-00AA00C14882");
        map.put("dt", "uuid:C2F41010-65B3-11d1-A29F-00AA00C14882");
        map.put("rs", "urn:schemas-microsoft-com:rowset");
        map.put("z", "#RowsetSchema");

        SAXReader saxReader = new SAXReader();
        File file = new File(TestDom4jWithNameSpace.class.getClassLoader().getResource("testChinese.xml").getPath());

        saxReader.getDocumentFactory().setXPathNamespaceURIs(map);
        Document document = saxReader.read(file);
        List<Node> tmp = document.selectNodes("//z:row");

        int sum = tmp.size();
        String testIng = "测试进行中";
        String passed = "测试通过";
        List<Node> testingNodeList = new ArrayList<Node>();
        List<Node> passedList = new ArrayList<Node>();
        for (Node node : tmp) {
            Element element = (Element) node;
            Attribute attribute = element.attribute("ows__x96f6__x552e__x8d44__x91d1__x530");
            if (attribute != null) {
                if (testIng.equals(attribute.getStringValue())) {
                    testingNodeList.add(node);
                } else if (passed.equals(attribute.getStringValue())) {
                    passedList.add(node);
                }
            }
        }

        NumberFormat numberFormat = NumberFormat.getPercentInstance();
        numberFormat.setMinimumFractionDigits(1);
        double t1 = (testingNodeList.size() + passedList.size()) * 1.0 / tmp.size();
        double t2 = passedList.size() * 1.0 / tmp.size();
        System.out.println(numberFormat.format(t1));
        System.out.println(numberFormat.format(t2));
    }

    public static String openUrl(String currentUrl, String charset) {
        InputStream is = null;
        BufferedReader br = null;
        URL url;
        StringBuffer html = new StringBuffer();
        try {
            url = new URL(currentUrl);
            URLConnection conn = url.openConnection();
            conn.setReadTimeout(5000);
            conn.connect();
            is = conn.getInputStream();
            br = new BufferedReader(new InputStreamReader(is, charset));
            String str;
            while (null != (str = br.readLine())) {
                html.append(str).append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return html.toString();
    }
}
