package com.maktab74.OnlineShop.domain;

public class Radio extends ElectronicProduct {
    private String WavesType;
    private String searchType;

    public Radio() {
    }

    public Radio(int id, String brand, int inventory, int price, String model, String powerConsumption, String communicationPortal, String wavesType, String searchType) {
        super(id, brand, inventory, price, model, powerConsumption, communicationPortal);
        WavesType = wavesType;
        this.searchType = searchType;
    }
}
