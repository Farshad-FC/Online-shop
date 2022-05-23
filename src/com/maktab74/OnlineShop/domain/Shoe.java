package com.maktab74.OnlineShop.domain;

public class Shoe extends Product {

    private String model;
    private String size;
    private String color;

    public Shoe() {
    }

    public Shoe(String brand, int inventory, int price, String model, String size, String color) {
        super(brand, inventory, price);
        this.model = model;
        this.size = size;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
