package com.shdev.note.nestingInterfaces;

/**
 * Created by ou_ko on 2016/9/28.
 */
public class NestingInterfaces {
    public static void main(String[] args) {
        A a = new A();
        a.getD();
    }
}

class A {
    private interface D {
        void f();
    }

    public D getD() {
        return new Dimp2();
    }

    public class Dimp2 implements D {
        @Override
        public void f() {

        }
    }
}
