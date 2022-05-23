package com.maktab74.OnlineShop.domain;

public class Cart {

    private ElectronicProduct[] electrics;

    private Shoe[] shoes;

    private Textual[] textuals;

    public Cart() {
    }

    public Cart(ElectronicProduct[] electrics, Shoe[] shoes, Textual[] textuals) {
        this.electrics = electrics;
        this.shoes = shoes;
        this.textuals = textuals;
    }

    public ElectronicProduct[] getElectrics() {
        return electrics;
    }

    public void setElectrics(ElectronicProduct[] electrics) {
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
