package com.maktab74.OnlineShop.domain;

public class Cart {

    private Electric[] electrics;

    private Shoe[] shoes;

    private Textual[] textuals;

    public Cart() {
    }

    public Cart(Electric[] electrics, Shoe[] shoes, Textual[] textuals) {
        this.electrics = electrics;
        this.shoes = shoes;
        this.textuals = textuals;
    }

    public Electric[] getElectrics() {
        return electrics;
    }

    public void setElectrics(Electric[] electrics) {
        this.electrics = electrics;
    }

    public Shoe[] getShoes() {
        return shoes;
    }

    public void setShoes(Shoe[] shoes) {
        this.shoes = shoes;
    }

    public Textual[] getTextuals() {
        return textuals;
    }

    public void setTextuals(Textual[] textuals) {
        this.textuals = textuals;
    }
}
