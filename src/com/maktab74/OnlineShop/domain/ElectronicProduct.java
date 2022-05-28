package com.maktab74.OnlineShop.domain;

public abstract class ElectronicProduct extends Product {

    private String model;
    private String powerConsumption;
    private String communicationPortal;

    public ElectronicProduct() {
    }

    public ElectronicProduct(int id, String brand, int inventory, int price, String model, String powerConsumption, String communicationPortal) {
        super(id, brand, inventory, price);
        this.model = model;
        this.powerConsumption = powerConsumption;
        this.communicationPortal = communicationPortal;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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

    @Override
    public String toString() {
        return "ElectronicProduct{" +
                super.toString() +
                "model='" + model + '\'' +
                ", powerConsumption='" + powerConsumption + '\'' +
                ", communicationPortal='" + communicationPortal + '\'' +
                '}';
    }
}
