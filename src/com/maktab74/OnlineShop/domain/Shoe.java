package com.maktab74.OnlineShop.domain;

public class Shoe extends Product {

    private String model;
    private String size;
    private String color;
    private String brand;
    private String closure;

    public Shoe() {
    }

    public Shoe(int id, String name, String type, int inventory, int price, String model, String size, String color, String brand, String closure) {
        super(id, name, type, inventory, price);
        this.model = model;
        this.size = size;
        this.color = color;
        this.brand = brand;
        this.closure = closure;
    }

    public Shoe(String name, String type, int inventory, int price, String model, String size, String color, String brand, String closure) {
        super(name, type, inventory, price);
        this.model = model;
        this.size = size;
        this.color = color;
        this.brand = brand;
        this.closure = closure;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getClosure() {
        return closure;
    }

    public void setClosure(String closure) {
        this.closure = closure;
    }
}
