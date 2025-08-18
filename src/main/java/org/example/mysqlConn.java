package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class mysqlConn {   // ✅ class name exactly as you asked

    private static final String URL = "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";        // change if needed
    private static final String PASSWORD = "9914";  // change to your MySQL password

    // Method to create a database (if not exists)
    public static void createDatabase(String dbName) {
        String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("✅ Database '" + dbName + "' created (or already exists).");

        } catch (SQLException e) {
            System.err.println("❌ Error creating database: " + e.getMessage());
        }
    }

    // Method to create a table inside a given database
    public static void createTable(String dbName,String tableName) {
        String urlWithDb = "jdbc:mysql://localhost:3306/" + dbName+ "?useSSL=false&serverTimezone=UTC";

        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "name VARCHAR(100) NOT NULL, "
                + "age INT NOT NULL, "
                + "department VARCHAR(50))";

        try (Connection conn = DriverManager.getConnection(urlWithDb, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate(sql);
            System.out.println("✅ Table " + tableName + " created in database '" + dbName + "'.");

        } catch (SQLException e) {
            System.err.println("❌ Error creating table: " + e.getMessage());
        }
    }

}
