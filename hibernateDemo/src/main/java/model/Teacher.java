package model;

import java.util.Set;

/**
 * Created by ou_kongli on 2015/6/12.
 */
public class Teacher {
    private int id;
    private String name;
    private Set<TeacherCourse> teacherCourses;

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

    public Set<TeacherCourse> getTeacherCourses() {
        return teacherCourses;
    }

    public void setTeacherCourses(Set<TeacherCourse> teacherCourses) {
        this.teacherCourses = teacherCourses;
    }
}
