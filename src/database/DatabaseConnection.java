/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    public static final String URL1 = "jdbc:mysql://192.168.1.186:3306/fragmentA";
    public static final String URL2 = "jdbc:mysql://192.168.1.186:3306/fragmentB_copy";
    public static final String URL3 = "jdbc:mysql://192.168.1.157:3306/fragmentB";
    public static final String URL4 = "jdbc:mysql://192.168.1.157:3306/fragmentA_copy";
    public static final String USER1 = "User_bolle";
    public static final String PASSWORD1 = "bolle";
    public static final String USER2 = "User_sidi";
    public static final String PASSWORD2 = "sidi";

    public static Connection getConnection(String url, String user, String password) throws SQLException {
        try {
            // Charger le pilote JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException("Unable to load MySQL Driver", ex);
        }
        return DriverManager.getConnection(url, user, password);
    }
}

