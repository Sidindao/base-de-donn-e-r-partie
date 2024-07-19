package middleware;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import database.DatabaseConnection;

public class Middleware {
    public static void main(String[] args) {
        try {
           
           
                          // Connexion avec user1 sur Machine 1 (Windows)
            Connection conn1 = DatabaseConnection.getConnection(DatabaseConnection.URL4, DatabaseConnection.USER1, DatabaseConnection.PASSWORD1);

           
              // Connexion avec user2 sur Machine 2 (Ubuntu)
            Connection conn2 = DatabaseConnection.getConnection(DatabaseConnection.URL1, DatabaseConnection.USER2, DatabaseConnection.PASSWORD2);

           
           
         
           
         
           
            String query = "SELECT * FROM Employee";
            ResultSet rs1 = executeQuery(conn1, query);
            ResultSet rs2 = executeQuery(conn2, query);

            while (rs1.next()) {
                System.out.println("ID: " + rs1.getInt("id") + ", Name: " + rs1.getString("name"));
            }

            while (rs2.next()) {
                System.out.println("ID: " + rs2.getInt("id") + ", Name: " + rs2.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static ResultSet executeQuery(Connection conn, String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }
}

