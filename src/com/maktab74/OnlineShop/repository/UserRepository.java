package com.maktab74.OnlineShop.repository;

import com.maktab74.OnlineShop.domain.Address;
import com.maktab74.OnlineShop.domain.User;

import java.sql.*;

public class UserRepository {
    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public User insert(User user) throws SQLException {
        String insertQuery = "insert into user(" +
                "username, password, first_name, last_name, phone_number, " +
                "email, province, city, street, postal_code" +
                ") values (? ,?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement =
                connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getFirstName());
        preparedStatement.setString(4, user.getLastName());
        preparedStatement.setString(5, user.getPhoneNumber());
        preparedStatement.setString(6, user.getEmail());
        preparedStatement.setString(7, user.getAddress().getProvince());
        preparedStatement.setString(8, user.getAddress().getCity());
        preparedStatement.setString(9, user.getAddress().getStreet());
        preparedStatement.setString(10, user.getAddress().getPostalCode());
        preparedStatement.executeUpdate();

        user.setId(getMaxId());

        return user;
    }

    public User getUserByUsernameAndPassword(String username, String password) throws SQLException {
        String query = "select * from user where username = ? and password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new User(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    new Address(
                            resultSet.getString(8),
                            resultSet.getString(9),
                            resultSet.getString(10),
                            resultSet.getString(11)
                    )
            );
        }

        return null;
    }

    public int getUserByUsername(String username) throws SQLException {
        String query = "select * from user where username = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return 1;
        }

        return 0;
    }

    public int getMaxId() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select max(id) from user");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }
}
