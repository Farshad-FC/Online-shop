package com.maktab74.OnlineShop.domain;

public class Textual extends Product {

    private String title;
    private String about;
    private String author;
    private String category;
    private String paperback;
    private String language;
    private String coverAndEdition;
    private String publication;

    public Textual() {
    }

    public Textual(int id, String name, String type, int inventory, int price, String title, String about, String author, String category, String paperback, String language, String coverAndEdition, String publication) {
        super(id, name, type, inventory, price);
        this.title = title;
        this.about = about;
        this.author = author;
        this.category = category;
        this.paperback = paperback;
        this.language = language;
        this.coverAndEdition = coverAndEdition;
        this.publication = publication;
    }

    public Textual(String name, String type, int inventory, int price, String title, String about, String author, String category, String paperback, String language, String coverAndEdition, String publication) {
        super(name, type, inventory, price);
        this.title = title;
        this.about = about;
        this.author = author;
        this.category = category;
        this.paperback = paperback;
        this.language = language;
        this.coverAndEdition = coverAndEdition;
        this.publication = publication;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }
}
