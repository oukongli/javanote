package com.shdev.demo.rest;

public class ExampleModel {
    private String name;
    private int id;

    public ExampleModel() {
    }

    public ExampleModel(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ExampleModel{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
