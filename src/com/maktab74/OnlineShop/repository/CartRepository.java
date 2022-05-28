package com.maktab74.OnlineShop.repository;

import com.maktab74.OnlineShop.domain.Cart;

import java.sql.*;
import java.util.ArrayList;

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

    public ArrayList<Cart> getAllCart() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from cart");

        ArrayList<Cart> carts = new ArrayList<Cart>();
        Cart cart;
        while (resultSet.next()) {
            cart = new Cart
                    (
                            resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getInt(3),
                            resultSet.getString(4),
                            resultSet.getInt(5),
                            resultSet.getInt(6)
                    );
            carts.add(cart);
        }
        return carts;
    }

    public Cart insert(Cart cart) throws SQLException {
        String insertQuery = "insert into cart(" +
                "user_id, product_id, category, number_of_product, total_price" +
                ") values (? ,?, ?, ?, ?)";

        PreparedStatement preparedStatement =
                connection.prepareStatement(insertQuery);
        preparedStatement.setInt(1, cart.getUserId());
        preparedStatement.setInt(2, cart.getProductId());
        preparedStatement.setString(3, cart.getProductType());
        preparedStatement.setInt(4, cart.getCount());
        preparedStatement.setInt(5, getPriceByProductId(cart) * cart.getCount());
        preparedStatement.executeUpdate();

        //user.setId(getMaxId());

        return cart;
    }

    private int getPriceByProductId(Cart cart) throws SQLException {

        String query = null;

        switch (cart.getProductType()) {
            case "tv":
                query = "select price from tv where id = ?";
                break;
            case "radio":
                query = "select price from radio where id = ?";
                break;
            case "shoe":
                query = "select price from shoe where id = ?";
                break;
            case "book":
                query = "select price from book where id = ?";
                break;
            case "magazine":
                query = "select price from magazine where id = ?";
                break;
        }

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, cart.getProductId());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    private int getInventoryByProductId(Cart cart) throws SQLException {

        String query = null;

        switch (cart.getProductType()) {
            case "tv":
                query = "select inventory from tv where id = ?";
                break;
            case "radio":
                query = "select inventory from radio where id = ?";
                break;
            case "shoe":
                query = "select inventory from shoe where id = ?";
                break;
            case "book":
                query = "select inventory from book where id = ?";
                break;
            case "magazine":
                query = "select inventory from magazine where id = ?";
                break;
        }

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, cart.getProductId());
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }

    public void deleteCartById(int cartId) throws SQLException {
        String deleteQuery = "delete from cart where id = ?";
        PreparedStatement preparedStatement =
                connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, cartId);
        preparedStatement.executeUpdate();
    }

    public void update(Cart cart) throws SQLException {
        String query = null;

        switch (cart.getProductType()) {
            case "tv":
                query = "update tv set inventory = ? where id = ?";
                break;
            case "radio":
                query = "update radio set inventory = ? where id = ?";
                break;
            case "shoe":
                query = "update shoe set inventory = ? where id = ?";
                break;
            case "book":
                query = "update book set inventory = ? where id = ?";
                break;
            case "magazine":
                query = "update magazine set inventory = ? where id = ?";
                break;
        }

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, getInventoryByProductId(cart) - cart.getCount());
        preparedStatement.setInt(2, cart.getProductId());
        preparedStatement.executeUpdate();
    }
}
