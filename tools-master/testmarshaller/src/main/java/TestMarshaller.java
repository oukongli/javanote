import javax.xml.bind.JAXB;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * Created by kouyang on 1/8/2015.
 */
public class TestMarshaller {
    public static void main(String[] args) {
        Home home = new Home("home1","home2");
        TestObject object = new TestObject("111",11,home);

//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//
//
//        JAXB.marshal(object,baos);
//        System.out.println(baos.toString());


        File file = new File("result.xml");

        JAXB.marshal(object,file);

        TestObject o = JAXB.unmarshal(file, TestObject.class);


        String t = String.valueOf(System.in);

    }
}
