package com.jsp.EmployeeDBApp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "employee_db";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    static {
        // Create DB if not exists
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + DB_NAME);
            System.out.println(" Database checked/created.");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Create Table if not exists
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            String createTableSQL = "CREATE TABLE IF NOT EXISTS employees (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(50) NOT NULL, " +
                    "email VARCHAR(50) UNIQUE NOT NULL, " +
                    "department VARCHAR(50), " +
                    "salary DOUBLE)";
            stmt.executeUpdate(createTableSQL);
            System.out.println(" Table checked/created.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + DB_NAME, USER, PASSWORD);
    }
}
