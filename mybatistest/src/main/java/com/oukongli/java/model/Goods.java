package com.oukongli.java.model;

/**
 * Created by ou_kongli on 2015/5/5.
 */
public class Goods {
    private int id;
    private String name;
    private double price;
    private String intro;
    private String img;
    private int stock;
    private Catetory catetory;

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Catetory getCatetory() {
        return catetory;
    }

    public void setCatetory(Catetory catetory) {
        this.catetory = catetory;
    }
}
