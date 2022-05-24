package com.maktab74.OnlineShop.repository;

import com.maktab74.OnlineShop.domain.Shoe;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ShoeRepository {
    private Connection connection;

    public ShoeRepository(Connection connection) {
        this.connection = connection;
    }


    public ArrayList<Shoe> getAllShoe() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from shoe");

        ArrayList<Shoe> shoes = new ArrayList<Shoe>();
        Shoe shoe;
        while (resultSet.next()) {
            shoe = new Shoe
                    (

                    );
            shoes.add(shoe);
        }
        return shoes;
    }
}
