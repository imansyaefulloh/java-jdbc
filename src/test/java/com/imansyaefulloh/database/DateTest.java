package com.imansyaefulloh.database;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class DateTest {

    @Test
    public void testDate() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = """
            INSERT INTO sample_time(sample_time, sample_date, sample_timestamp)
            VALUES (?, ?, ?)
            """;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setTime(1, new Time(System.currentTimeMillis()));
        preparedStatement.setDate(2, new Date(System.currentTimeMillis()));
        preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    @Test
    public void testDateQuery() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String sql = "SELECT * FROM sample_time";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Time time = resultSet.getTime("sample_time");
            Date date = resultSet.getDate("sample_date");
            Timestamp timestamp = resultSet.getTimestamp("sample_timestamp");
            System.out.println(time + " " + date +" "+ timestamp);
        }

        preparedStatement.close();
        connection.close();
    }
}
