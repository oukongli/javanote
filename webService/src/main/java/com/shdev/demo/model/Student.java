package com.shdev.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by ou_ko on 2016/4/25.
 */
@XmlRootElement
public class Student {
    private int id;
    private String name;
    private String sex;
    private Classroom classroom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
