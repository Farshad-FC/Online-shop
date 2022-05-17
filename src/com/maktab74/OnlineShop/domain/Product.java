package com.maktab74.OnlineShop.domain;

public class Product {
    private int id;
    private String name;
    private String type;
    private int inventory;
    private int Price;

    public Product() {
    }

    public Product(int id, String name, String type, int inventory, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.inventory = inventory;
        Price = price;
    }

    public Product(String name, String type, int inventory, int price) {
        this.name = name;
        this.type = type;
        this.inventory = inventory;
        Price = price;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }
}
