package com.maktab74.OnlineShop.domain;

public class Book extends Textual {
    private String author;

    public Book() {
    }

    public Book(int id, String brand, int inventory, int price, String title, String category, String paperback, String language, String coverAndEdition, String author) {
        super(id, brand, inventory, price, title, category, paperback, language, coverAndEdition);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                super.toString() +
                "author='" + author + '\'' +
                '}';
    }
}
