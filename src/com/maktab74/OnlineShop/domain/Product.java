package com.maktab74.OnlineShop.domain;

public abstract class Product extends Base {
    private String brand;
    private int inventory;
    private int Price;

    public Product() {
    }

    public Product(int id, String brand, int inventory, int price) {
        super(id);
        this.brand = brand;
        this.inventory = inventory;
        Price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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
