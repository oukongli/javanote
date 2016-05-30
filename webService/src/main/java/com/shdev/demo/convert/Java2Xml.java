package com.shdev.demo.convert;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.shdev.demo.model.Classroom;
import com.shdev.demo.model.Student;

/**
 * Created by ou_ko on 2016/4/25.
 */
@SuppressWarnings("restriction")
public class Java2Xml implements Convert {
    public void convert() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(getStudentInstance(), System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Student getStudentInstance() {
        Student student = new Student();
        student.setId(1);
        student.setName("test");
        Classroom classroom = new Classroom();
        classroom.setId("classroom 1");
        classroom.setGrade(1);
        classroom.setName("classroom 1");
        student.setClassroom(classroom);
        return student;
    }
}
