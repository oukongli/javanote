package com.shdev.note.innerClass;

/**
 * Created by ou_ko on 2016/9/28.
 */
public class DotThis {
    void f() {
        System.out.println("DotThis.f()");
    }

    public class Inner {
        public DotThis outer() {
            return DotThis.this;
        }
    }

    public Inner inner() {
        return new Inner();
    }

    public static void main(String[] args) {
        DotThis dt = new DotThis();
        DotThis.Inner inner = dt.inner();
        dt.f();
        System.out.println(inner.outer() == dt);
    }
}
