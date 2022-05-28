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

        initTVTable();

        initRadioTable();

        initShoeTable();

        initBookTable();

        initMagazineTable();

        initCartTable();
    }

    private void initRadioTable() throws SQLException {
        String createRadioTable =
                "create table if not exists radio" +
                        "(" +
                        "id int not null unique auto_increment," +
                        "model varchar(45) not null," +
                        "brand varchar(20) not null," +
                        "waves_type varchar(20) not null," +
                        "search_type varchar(30) not null," +
                        "power_consumption varchar(5) not null," +
                        "communication_portal varchar(127) not null," +
                        "inventory int not null," +
                        "price int not null," +
                        "primary key (id)" +
                        ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createRadioTable);
    }

    private void initTVTable() throws SQLException {
        String createTVTable =
                "create table if not exists tv" +
                        "(" +
                        "id int not null unique auto_increment," +
                        "model varchar(45) not null," +
                        "brand varchar(20) not null," +
                        "screen_size varchar(3) not null," +
                        "quality_resolution varchar(30) not null," +
                        "power_consumption varchar(5) not null," +
                        "communication_portal varchar(127) not null," +
                        "number_of_speakers varchar(2) not null," +
                        "inventory int not null," +
                        "price int not null," +
                        "primary key (id)" +
                        ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createTVTable);
    }

    private void initMagazineTable() throws SQLException {
        String createMagazineTable =
                "create table if not exists magazine" +
                        "(" +
                        "id int not null unique auto_increment," +
                        "title varchar(255) not null," +
                        "category varchar(63) not null," +
                        "paperback varchar(4) not null," +
                        "language varchar(20) not null," +
                        "publishing_period varchar(20) not null," +
                        "cover_and_edition varchar(63) not null," +
                        "publication varchar(63) not null," +
                        "inventory int not null," +
                        "price int not null," +
                        "primary key (id)" +
                        ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createMagazineTable);
    }

    private void initBookTable() throws SQLException {
        String createBookTable =
                "create table if not exists book" +
                        "(" +
                        "id int not null unique auto_increment," +
                        "title varchar(255) not null," +
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
        statement.executeUpdate(createBookTable);
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
                "create table if not exists shoe" +
                        "(" +
                        "id int not null unique auto_increment," +
                        "model varchar(45) not null," +
                        "size varchar(2) not null," +
                        "color varchar(20) not null," +
                        "brand varchar(20) not null," +
                        "inventory int not null," +
                        "price int not null," +
                        "primary key (id)" +
                        ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createShoeTable);
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
                        "first_name varchar(20) ," +
                        "last_name varchar(20) ," +
                        "phone_number varchar(11) unique," +
                        "email varchar(64) unique," +
                        "province varchar(20)," +
                        "city varchar(20)," +
                        "street varchar(255)," +
                        "postal_code varchar(10) unique," +
                        "primary key (id)" +
                        ")";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createUserTable);
    }
}
