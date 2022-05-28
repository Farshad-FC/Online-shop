package com.maktab74.OnlineShop.domain;

public class Magazine extends Textual {
    private String publishingPeriod;

    public Magazine() {
    }

    public Magazine(int id, String brand, int inventory, int price, String title, String category, String paperback, String language, String coverAndEdition, String publishingPeriod) {
        super(id, brand, inventory, price, title, category, paperback, language, coverAndEdition);
        this.publishingPeriod = publishingPeriod;
    }

    public String getPublishingPeriod() {
        return publishingPeriod;
    }

    public void setPublishingPeriod(String publishingPeriod) {
        this.publishingPeriod = publishingPeriod;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                super.toString() +
                "publishingPeriod='" + publishingPeriod + '\'' +
                '}';
    }
}
