/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transactions;

import database.DBConnection;
import java.sql.*;
import java.util.ArrayList;

public class TransactionDAOImpl implements TransactionDAO {
    public boolean create(Transaction transaction){
        String query = "INSERT INTO transactions (product_id, quantity, total_price, user_id, date) "
                + "VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, transaction.getProduct_id());
            pstmt.setInt(2, transaction.getQuantity());
            pstmt.setDouble(3, transaction.getTotal_price());
            pstmt.setInt(4, transaction.getUser_id());
            pstmt.setString(5, transaction.getDate());
            pstmt.executeUpdate();
                        
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            
            return false;
        }
    }
    
    public Transaction read_one(int transaction_id){
        Transaction transaction = null;
        String query = "SELECT * FROM transactions WHERE transaction_id = ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, transaction_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                transaction = new Transaction(rs.getInt("transaction_id"), rs.getInt("product_id"), 
                        rs.getInt("quantity"), rs.getDouble("total_price"), rs.getInt("user_id"), 
                        rs.getString("date"));
            }
            
            return transaction;
        } catch (SQLException e) {
            e.printStackTrace();
            
            return transaction;
        }
    }
    
    public ArrayList<Transaction> read_all(){
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        String query = "SELECT * FROM transactions";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                transactions.add(new Transaction(rs.getInt("transaction_id"), rs.getInt("product_id"), 
                        rs.getInt("quantity"), rs.getDouble("total_price"), rs.getInt("user_id"), 
                        rs.getString("date")));
            }
            
            return transactions;
        } catch (SQLException e) {
            e.printStackTrace();
            
            return transactions;
        }
    }
    
    public boolean delete(int transaction_id){
        String query = "DELETE FROM transactions WHERE transaction_id = ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, transaction_id);
            pstmt.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            
            return false;
        }
    }
    
    public ArrayList<Transaction> readTransactionsByUser(int user_id){
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        String query = "SELECT * FROM transactions WHERE user_id = ? ORDER BY date DESC";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, user_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                transactions.add(new Transaction(rs.getInt("transaction_id"), rs.getInt("product_id"), 
                        rs.getInt("quantity"), rs.getDouble("total_price"), rs.getInt("user_id"), 
                        rs.getString("date")));
            }
            
            return transactions;
        } catch (SQLException e) {
            e.printStackTrace();
            
            return transactions;
        }
    }
}
