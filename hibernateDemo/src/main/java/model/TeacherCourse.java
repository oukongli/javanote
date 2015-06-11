package model;

import java.util.Set;

/**
 * Created by ou_kongli on 2015/6/12.
 */
public class TeacherCourse {
    private int id;
    private double ach;
    private Teacher teacher;
    private Course course;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAch() {
        return ach;
    }

    public void setAch(double ach) {
        this.ach = ach;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
