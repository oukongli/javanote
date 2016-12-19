package com.shdev.note.rawtype;

/**
 * Created by ou_ko on 2016/12/20.
 */

interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}

interface Getter extends GenericGetter<Getter> {

}

public class GenericsAndReturnTypes {
    void test(Getter g) {
        Getter result = g.get();
        GenericGetter genericGetter = g.get();
    }
}
