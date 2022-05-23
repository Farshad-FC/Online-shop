package com.maktab74.OnlineShop.domain;

public class TV extends ElectronicProduct {
    private int screenSize;
    private String qualityResolution;
    private String numberOfSpeakers;

    public TV() {
    }

    public TV(int id, String brand, int inventory, int price, String model, String powerConsumption, String communicationPortal, int screenSize, String qualityResolution, String numberOfSpeakers) {
        super(id, brand, inventory, price, model, powerConsumption, communicationPortal);
        this.screenSize = screenSize;
        this.qualityResolution = qualityResolution;
        this.numberOfSpeakers = numberOfSpeakers;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public String getQualityResolution() {
        return qualityResolution;
    }

    public void setQualityResolution(String qualityResolution) {
        this.qualityResolution = qualityResolution;
    }

    public String getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(String numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }
}
