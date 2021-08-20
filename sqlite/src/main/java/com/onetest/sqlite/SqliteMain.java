package com.onetest.sqlite;

import org.springframework.jdbc.core.JdbcTemplate;
import org.sqlite.SQLiteDataSource;

import java.sql.SQLException;
import java.util.Map;

/**
 * @author guize
 * @date 2021/8/20
 */
public class SqliteMain {
    public static void main(String[] args) throws SQLException {
        SQLiteDataSource dataSource = new SQLiteDataSource();
        dataSource.setUrl("jdbc:sqlite:/Users/guize/Documents/Aone/onetest/onetest.sqlite");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        final Integer i = jdbcTemplate.queryForObject("select 1", Integer.class);
        System.out.println(i);

        /*String url = "jdbc:sqlite:/Users/guize/Documents/Aone/onetest/onetest.sqlite";
        Connection conn = DriverManager.getConnection(url);
        final PreparedStatement statement = conn.prepareStatement("select 1");
        final ResultSet resultSet = statement.executeQuery();
        final String now = resultSet.getString(1);
        System.out.println(now);*/
    }
}
