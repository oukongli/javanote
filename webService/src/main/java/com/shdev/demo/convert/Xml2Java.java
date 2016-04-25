package com.shdev.demo.convert;

import com.shdev.demo.model.Student;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

/**
 * Created by ou_ko on 2016/4/25.
 */
public class Xml2Java implements Convert {
    public void convert() {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><student><classroom><grade>1</grade><id>classroom 1</id><name>classroom 1</name></classroom><id>1</id><name>test</name></student>";
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Unmarshaller unmarshal = jaxbContext.createUnmarshaller();
            Student student = (Student) unmarshal.unmarshal(new StringReader(str));
            System.out.println(student.getId());
            System.out.println(student.getName());
            System.out.println(student.getClassroom().getName());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
