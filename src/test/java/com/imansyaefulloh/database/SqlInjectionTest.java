package com.imansyaefulloh.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlInjectionTest {

    @Test
    void testSqlInjection() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        Statement statement = connection.createStatement();

        String username = "admin'; #";
        String password = "salah";

        String sql = "SELECT * FROM admin WHERE username = '" + username + "' AND password = '" + password + "'";

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            String username2 = resultSet.getString("username");

            System.out.println("Sukses login : " + username2);
        } else {
            System.out.println("Gagal login");
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
