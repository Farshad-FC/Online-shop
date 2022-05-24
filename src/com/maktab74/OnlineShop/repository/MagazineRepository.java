package com.maktab74.OnlineShop.repository;

import com.maktab74.OnlineShop.domain.Magazine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MagazineRepository {
    private Connection connection;

    public MagazineRepository(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Magazine> getAllMagazine() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from magazine");

        ArrayList<Magazine> magazines = new ArrayList<Magazine>();
        Magazine magazine;
        while (resultSet.next()) {
            magazine = new Magazine
                    (

                    );
            magazines.add(magazine);
        }
        return magazines;
    }
}
