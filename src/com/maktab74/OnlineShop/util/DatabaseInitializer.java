package com.maktab74.OnlineShop.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer {
    private Connection connection;

    private String schemaName = "OnlineShop";

    public DatabaseInitializer(Connection connection) {
        this.connection = connection;
    }

    public void init() throws SQLException {
        initSchema();

        initUserTable();

        initElectricTable();

        initShoeTable();

        initTextualTable();

        initCartTable();
    }

    private void initCartTable() throws SQLException {
        String createCartTable =
                "create table if not exists cart" +
                        "(" +
                        "id int not null unique auto_increment," +
                        "user_id int not null," +
                        "product_id int not null," +
                        "category varchar(10) not null," +
                        "number_of_product int not null," +
                        "total_price int not null," +
                        "primary key (id)," +
                        "FOREIGN KEY (user_id) REFERENCES user(id)" +
                        ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createCartTable);
    }

    private void initShoeTable() throws SQLException {
        String createShoeTable =
                "create table if not exists tag" +
                        "(" +
                        "id int not null unique auto_increment," +
                        "name varchar(45) not null," +
                        "type varchar(45) not null," +
                        "model varchar(45) not null," +
                        "size varchar(2) not null," +
                        "color varchar(20) not null," +
                        "brand varchar(20) not null," +
                        "closure varchar(20) not null," +
                        "inventory int not null," +
                        "price int not null," +
                        "primary key (id)" +
                        ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createShoeTable);
    }

    private void initElectricTable() throws SQLException {
        String createElectricTable =
                "create table if not exists category" +
                        "(" +
                        "id int not null unique auto_increment," +
                        "name varchar(45) not null," +
                        "type varchar(45) not null," +
                        "model varchar(45) not null," +
                        "brand varchar(20) not null," +
                        "power_consumption varchar(5) not null," +
                        "communication_portal varchar(127) not null," +
                        "number_of_speakers varchar(2) not null," +
                        "inventory int not null," +
                        "price int not null," +
                        "primary key (id)" +
                        ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createElectricTable);
    }

    private void initSchema() throws SQLException {
        String createSchemaQuery = "create schema if not exists " + schemaName;

        Statement statement = connection.createStatement();
        statement.executeUpdate(createSchemaQuery);

        statement = connection.createStatement();
        statement.executeUpdate("use " + schemaName);

    }

    private void initUserTable() throws SQLException {
        String createUserTable =
                "create table if not exists user" +
                        "(" +
                        "id int not null unique auto_increment," +
                        "username varchar(255) unique," +
                        "password varchar(255)," +
                        "firstName varchar(20) ," +
                        "lastName varchar(20) ," +
                        "phoneNumber varchar(11) unique," +
                        "email varchar(64) unique," +
                        "province varchar(20)," +
                        "city varchar(20)," +
                        "street varchar(255)," +
                        "postalCode varchar(10) unique," +
                        "primary key (id)" +
                        ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createUserTable);
    }

    private void initTextualTable() throws SQLException {
        String createArticleTable =
                "create table if not exists article" +
                        "(" +
                        "id int not null unique auto_increment," +
                        "name varchar(45) not null," +
                        "type varchar(45) not null," +
                        "title varchar(255) not null," +
                        "about varchar(255) not null," +
                        "author varchar(127) not null," +
                        "category varchar(63) not null," +
                        "paperback varchar(4) not null," +
                        "language varchar(20) not null," +
                        "cover_and_edition varchar(63) not null," +
                        "publication varchar(63) not null," +
                        "inventory int not null," +
                        "price int not null," +
                        "primary key (id)" +
                        ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createArticleTable);
    }
}
