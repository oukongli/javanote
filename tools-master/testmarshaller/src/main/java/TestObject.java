/**
 * Created by kouyang on 1/8/2015.
 */
public class TestObject {
    private String name;
    private int age;
    private Home home;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TestObject(String name, int age, Home home) {
        this.name = name;
        this.age = age;
        this.home = home;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    public TestObject(){

    }

}
