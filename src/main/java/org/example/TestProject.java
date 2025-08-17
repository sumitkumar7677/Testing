package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class TestProject {
    public static void main(String[] args) {
        // Updated JDBC URL with SSL disabled and public key retrieval allowed
        String url = "jdbc:mysql://localhost:3306/newDb";
        String user = "root";
        String password = "9914";
        try {Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL!");

            // Execute a simple query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NOW()");
            if (rs.next()) {
                System.out.println("Current DB Time: " + rs.getString(1));
            }

            // Close connection
            conn.close();
            System.out.println("✅ Connection closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}