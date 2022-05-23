package com.maktab74.OnlineShop.domain;

public abstract class Textual extends Product {

    private String title;
    private String category;
    private String paperback;
    private String language;
    private String coverAndEdition;

    public Textual() {
    }

    public Textual(int id, String brand, int inventory, int price, String title, String category, String paperback, String language, String coverAndEdition) {
        super(id, brand, inventory, price);
        this.title = title;
        this.category = category;
        this.paperback = paperback;
        this.language = language;
        this.coverAndEdition = coverAndEdition;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPaperback() {
        return paperback;
    }

    public void setPaperback(String paperback) {
        this.paperback = paperback;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCoverAndEdition() {
        return coverAndEdition;
    }

    public void setCoverAndEdition(String coverAndEdition) {
        this.coverAndEdition = coverAndEdition;
    }
}
