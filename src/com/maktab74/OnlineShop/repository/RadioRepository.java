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

                    );
            radios.add(radio);
        }
        return radios;
    }
}
