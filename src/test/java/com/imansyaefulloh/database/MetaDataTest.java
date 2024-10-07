package com.imansyaefulloh.database;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetaDataTest {
    @Test
    public void testMetaData() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        DatabaseMetaData metaData = connection.getMetaData();

        System.out.println(metaData.getDatabaseProductName());
        System.out.println(metaData.getDatabaseProductVersion());

        ResultSet resultSet = metaData.getTables("java_db", null, null, null);
        while (resultSet.next()) {
            String tableName = resultSet.getString("TABLE_NAME");
            System.out.println("Table: " + tableName);
        }

        connection.close();
    }
}
