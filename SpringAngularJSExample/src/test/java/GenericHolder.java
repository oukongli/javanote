/**
 * Created by ou_ko on 2016/12/14.
 */
public class GenericHolder <T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public static void main(String[] args) {
        GenericHolder<String>  holder = new GenericHolder<String>();
        holder.setObj("1");
        String s = holder.getObj();
    }
}
