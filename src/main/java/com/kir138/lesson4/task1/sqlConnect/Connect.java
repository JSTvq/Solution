package com.kir138.lesson4.task1.sqlConnect;

import com.kir138.lesson4.task1.model.Role;
import com.kir138.lesson4.task1.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class Connect {

    String url = "jdbc:postgresql://localhost:5432/postgres";
    String username = "postgres";
    String password = "12341234";

    protected Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Failed to close the connection: " + e.getMessage());
            }
        }
    }
}
