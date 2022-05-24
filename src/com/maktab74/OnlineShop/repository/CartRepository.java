package com.maktab74.OnlineShop.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CartRepository {
    private Connection connection;

    public CartRepository(Connection connection) {
        this.connection = connection;
    }

    public void delete() throws SQLException {
        Statement statement = connection.createStatement();
        String deleteQuery = "delete from cart";
        statement.executeUpdate(deleteQuery);
    }
}
