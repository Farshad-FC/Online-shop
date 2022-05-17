package com.maktab74.OnlineShop.domain;

public class Electric extends Product {
    private String model;
    private String brand;
    private String powerConsumption;
    private String communicationPortal;
    private String numberOfSpeakers;

    public Electric() {
    }

    public Electric(int id, String name, String type, int inventory, int price, String model, String brand, String powerConsumption, String communicationPortal, String numberOfSpeakers) {
        super(id, name, type, inventory, price);
        this.model = model;
        this.brand = brand;
        this.powerConsumption = powerConsumption;
        this.communicationPortal = communicationPortal;
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public Electric(String name, String type, int inventory, int price, String model, String brand, String powerConsumption, String communicationPortal, String numberOfSpeakers) {
        super(name, type, inventory, price);
        this.model = model;
        this.brand = brand;
        this.powerConsumption = powerConsumption;
        this.communicationPortal = communicationPortal;
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(String powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getCommunicationPortal() {
        return communicationPortal;
    }

    public void setCommunicationPortal(String communicationPortal) {
        this.communicationPortal = communicationPortal;
    }

    public String getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(String numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }
}
