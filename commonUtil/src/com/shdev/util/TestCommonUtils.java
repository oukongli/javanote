package com.shdev.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by ou_ko on 2016/8/1.
 */
public class TestCommonUtils {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        TestObject object = CommonUtils.newObject(TestObject.class);
//        System.out.println(object);
//
//        TestObject testObject = CommonUtils.newObject(TestCommonUtils.TestObject.class, 1, "name");
//        System.out.println(testObject);


        Class<?> enclosingClass = TestCommonUtils.class;
        Object enclosingInstance = enclosingClass.newInstance();

        Class<?> innerClass = TestCommonUtils.TestObject.class;
        Constructor<?> ctor = innerClass.getDeclaredConstructor(enclosingClass);

        ctor.newInstance(enclosingInstance);
        System.out.println(ctor.newInstance(enclosingInstance));
    }

    class TestObject {
        private Integer id;
        private String name;

        @Override
        public String toString() {
            return "TestObject{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public TestObject() {
        }

        public TestObject(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
