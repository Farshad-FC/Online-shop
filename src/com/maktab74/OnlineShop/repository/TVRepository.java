package com.maktab74.OnlineShop.repository;

import com.maktab74.OnlineShop.domain.TV;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TVRepository {
    private Connection connection;

    public TVRepository(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<TV> getAllTV() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from tv");

        ArrayList<TV> tvs = new ArrayList<TV>();
        TV tv;
        while (resultSet.next()) {
            tv = new TV
                    (
                            resultSet.getInt(1),
                            resultSet.getString(3),
                            resultSet.getInt(9),
                            resultSet.getInt(10),
                            resultSet.getString(2),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(8)
                    );
            tvs.add(tv);
        }
        return tvs;
    }
}
