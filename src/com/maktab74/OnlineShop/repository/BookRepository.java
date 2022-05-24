package com.maktab74.OnlineShop.repository;

import com.maktab74.OnlineShop.domain.Book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookRepository {
    private Connection connection;

    public BookRepository(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Book> getAllBook() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from book");

        ArrayList<Book> books = new ArrayList<Book>();
        Book book;
        while (resultSet.next()) {
            book = new Book
                    (

                    );
            books.add(book);
        }
        return books;
    }
}
