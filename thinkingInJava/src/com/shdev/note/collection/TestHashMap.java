package com.shdev.note.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ou_ko on 2017/1/3.
 */
public class TestHashMap {
    static class Model {
        private int id;
        private String name;

        public Model() {
        }

        public Model(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int hashCode() {
            return this.id + this.name.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof Model)) return false;
            Model model = (Model) obj;
            return model.getId() == this.id && model.getName() != null && model.getName().equals(this.getName());
        }
    }

    public static void main(String[] args) {
        Model model = new Model();
        model.setId(1);
        model.setName("name");
        Map<String, Model> modelMap = new HashMap<>();
        modelMap.put(model.getName(), model);
        System.out.println(modelMap.size());
        model.setName("456");
        modelMap.put(model.getName(), model);
        System.out.println(modelMap.size());
        System.out.println(modelMap.containsValue(model));
        System.out.println(modelMap.containsKey("123"));
    }
}
