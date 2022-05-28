package com.maktab74.OnlineShop.domain;

public abstract class Base {
    private int id;

    public Base() {
    }

    public Base(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                '}';
    }
}
