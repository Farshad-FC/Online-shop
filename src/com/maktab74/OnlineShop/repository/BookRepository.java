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
                            resultSet.getInt(1),
                            resultSet.getString(8),
                            resultSet.getInt(9),
                            resultSet.getInt(10),
                            resultSet.getString(2),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(3)
                    );
            books.add(book);
        }
        return books;
    }

    public int getCountBook() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select count(id) from book");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }
}
