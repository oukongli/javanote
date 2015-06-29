package demo.prototype;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kouyang on 6/3/2015.
 */
public class SerializableObject implements Serializable {
    private List<String> names = new ArrayList<String>();

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}