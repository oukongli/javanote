package demo.template;

/**
 * Created by ou_kongli on 2015/6/29.
 */
public abstract class MyTemplate {
    private void begin() {
        System.out.println("begin");
    }

    private void end() {
        System.out.println("end");
    }

    /**
     * 钩子函数，作用是让实现类可以通过一些方法来控制模板中的流程
     */
    protected abstract void run();

    public void execute() {
        begin();
        run();
        end();
    }
}
