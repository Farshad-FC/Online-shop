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
                            resultSet.getInt(1),
                            resultSet.getString(8),
                            resultSet.getInt(9),
                            resultSet.getInt(10),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(7),
                            resultSet.getString(6)
                    );
            magazines.add(magazine);
        }
        return magazines;
    }

    public int getCountMagazine() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select count(id) from magazine");
        if (resultSet.next()) {
            return resultSet.getInt(1);
        }
        return 0;
    }
}
