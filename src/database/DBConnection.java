/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.*;

public class DBConnection {
     // Database URL, Username, and Password
    private static final String URL = "jdbc:mysql://192.168.16.205:3306/fenad_pos_db";      
    private static final String USER = "fenad";      
    private static final String PASSWORD = "fenad";  

    // Method to establish a connection to the database
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            return null;
        }
    }
    
    /*
    public static void main(String args[]){
        Connection conn = DBConnection.getConnection();
        
        if(conn == null){
            System.out.println("Error was encountered!");
        } else {
            System.out.println("Connection was successful!");
        }
    
    }
    */
}
