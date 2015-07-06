package demo.template;

/**
 * Created by ou_kongli on 2015/6/29.
 */
public class MyTemplate2 {

    private void begin() {
        System.out.println("begin");
    }

    private void end() {
        System.out.println("end");
    }

    public void add() {
        execute(new MyCallBack() {
            public void doInTemplate() {
                System.out.println("add");
            }
        });
    }

    public void delete() {
        execute(new MyCallBack() {
            public void doInTemplate() {
                System.out.println("delete");
            }
        });
    }

    public void execute(MyCallBack callBack) {
        begin();
        callBack.doInTemplate();
        end();
    }
}
