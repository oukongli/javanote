package com.shdev.note.initclass;

/**
 * Created by ou_ko on 2016/9/25.
 */
public class ClassInitOrder {
    static class Inner {
        private String desc;

        public Inner(String desc) {
            this.desc = desc;
            System.out.println("base " + desc);
        }
    }

    static Inner inner_1;
    static Inner inner_2 = new Inner("inner_2");

    static {
        inner_1 = new Inner("inner_1");
        inner_3 = new Inner("inner_3");
    }

    static Inner inner_3 = new Inner("inner_3_0");

    public static void main(String[] args) {

    }
}
