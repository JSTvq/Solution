package com.kir138.lesson4.task1.sqlConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {

    private final Connection connection = PgConnect.getConnection();

    public void createTableUsers(String tableName) {
        String createTableSql = "CREATE TABLE if not exists " + tableName + " ("
            + "id SERIAL PRIMARY KEY, "
            + "name TEXT NOT NULL, "
            + "age INT NOT NULL, "
            + "salary INT NOT NULL, "
            + "role TEXT NOT NULL, "
            + "team_id INT)";

        try(Statement statement = connection.createStatement()) {
            statement.execute(createTableSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTableTeams(String tableName) {
        String createTableSql = "CREATE TABLE if not exists " + tableName + " ("
            + "id SERIAL PRIMARY KEY, "
            + "name TEXT NOT NULL, "
            + "department TEXT NOT NULL)";

        try(Statement statement = connection.createStatement()) {
            statement.execute(createTableSql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
