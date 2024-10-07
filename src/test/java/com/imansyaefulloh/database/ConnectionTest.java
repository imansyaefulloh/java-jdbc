package com.imansyaefulloh.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    @BeforeAll
    static void beforeAll() {
        try {
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(mysqlDriver);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    @Test
    void testConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/java_db";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            System.out.println("Successfully connected to database");
        } catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }
}
