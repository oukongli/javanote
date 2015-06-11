package model;

import java.util.Set;

/**
 * Created by ou_kongli on 2015/6/11.
 */
public class Role {
    private int id;
    private String name;
    private Set<Admin> admins;

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

    public Set<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(Set<Admin> admins) {
        this.admins = admins;
    }
}
