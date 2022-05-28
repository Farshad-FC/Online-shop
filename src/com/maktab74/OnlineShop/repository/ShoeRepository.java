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
                            resultSet.getInt(1),
                            resultSet.getString(5),
                            resultSet.getInt(6),
                            resultSet.getInt(7),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)
                    );
            shoes.add(shoe);
        }
        return shoes;
    }

    public int getCountShoe() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select count(id) from shoe");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }
}
