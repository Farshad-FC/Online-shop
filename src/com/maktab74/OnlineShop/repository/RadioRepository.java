package com.maktab74.OnlineShop.repository;

import com.maktab74.OnlineShop.domain.Radio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RadioRepository {
    private Connection connection;

    public RadioRepository(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Radio> getAllRadio() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from radio");

        ArrayList<Radio> radios = new ArrayList<Radio>();
        Radio radio;
        while (resultSet.next()) {
            radio = new Radio
                    (
                            resultSet.getInt(1),
                            resultSet.getString(3),
                            resultSet.getInt(8),
                            resultSet.getInt(9),
                            resultSet.getString(2),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(4),
                            resultSet.getString(5)
                    );
            radios.add(radio);
        }
        return radios;
    }

    public int getCountRadio() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select count(id) from radio");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }
}
