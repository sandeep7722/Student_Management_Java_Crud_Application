package com.crud.app.student;
import java.sql.*;
public class DatabaseConnection {
    private static final String url ="jdbc:mysql://127.0.0.1:3306/?user=root";
    private static final String username = "root";
    private static final String password = "Root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
