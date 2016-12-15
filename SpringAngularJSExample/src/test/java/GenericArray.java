import java.util.ArrayList;
import java.util.List;

/**
 * Created by ou_ko on 2016/12/14.
 */
public class GenericArray<T> {
    private T[] array;

    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> array = new GenericArray<Integer>(5);
        Object[] integers = array.rep();
    }
}
