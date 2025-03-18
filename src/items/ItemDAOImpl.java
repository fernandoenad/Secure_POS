/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package items;

import database.DBConnection;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author fernandoenad
 */
public class ItemDAOImpl {
    public boolean create(Item item){
        String query = "INSERT INTO items(invoice_id, product_id, quantity) VALUES(?, ?, ?)";
        
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, item.getInvoice_id());
            pstmt.setDouble(2, item.getProduct_id());
            pstmt.setDouble(3, item.getQuantity());
            pstmt.executeUpdate();
            
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            
            return false;
        }
    }
    
    public boolean update(int item_id, Item item){
        String query = "UPDATE items SET quantity = ? WHERE item_id = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, item.getQuantity());
            pstmt.setInt(2, item_id);
            pstmt.executeUpdate();
            
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            
            return false;
        }
    }
    
    public boolean delete(int item_id){
        String query = "DELETE FROM items WHERE item_id = ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, item_id);
            pstmt.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            
            return false;
        }
    }
    
    public ArrayList<Item> readItemsByInvoice(int invoice_id){
        ArrayList<Item> items = new ArrayList<Item>();
        String query = "SELECT * FROM items WHERE invoice_id = ? ORDER BY invoice_id ASC";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, invoice_id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                items.add(new Item(rs.getInt("item_id"), 
                        rs.getInt("invoice_id"), 
                        rs.getInt("product_id"),
                        rs.getInt("quantity")
                ));
            }
            return items;
        } catch (SQLException e){
            e.printStackTrace();
            return items;
        }
    
    }
    
}
