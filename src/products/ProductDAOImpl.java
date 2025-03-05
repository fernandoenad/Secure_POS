/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package products;

import database.DBConnection;
import java.util.ArrayList;
import java.sql.*;

public class ProductDAOImpl implements ProductDAO {
    public boolean create(Product product){
        String query = "INSERT INTO products (name, price, stock) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setInt(3, product.getStock());
            pstmt.executeUpdate();
                        
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            
            return false;
        }
    }
    
    public Product read_one(int product_id){
        Product product = null;
        String query = "SELECT * FROM products WHERE product_id = ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, product_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                product = new Product(rs.getInt("product_id"), rs.getString("name"), 
                        rs.getDouble("price"), rs.getInt("stock"));
            }
            
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
            
            return product;
        }
    }
    
    public ArrayList<Product> read_all(){
        ArrayList<Product> products = new ArrayList<Product>();
        String query = "SELECT * FROM products";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getInt("product_id"), rs.getString("name"), 
                        rs.getDouble("price"), rs.getInt("stock")));
            }
            
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            
            return products;
        }
    }
    
    public boolean update(int product_id, Product product){
        String query = "UPDATE products SET name = ?, price = ?, stock = ? WHERE product_id = ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice()); 
            pstmt.setInt(3, product.getStock());
            pstmt.setInt(4, product_id);
            pstmt.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            
            return false;
        }
    }
    
    public boolean delete(int product_id){
        String query = "DELETE FROM products WHERE product_id = ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, product_id);
            pstmt.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            
            return false;
        }
    }
    
    public ArrayList<Product> search(String str){
        ArrayList<Product> products = new ArrayList<Product>();
        String query = "SELECT * FROM products WHERE name LIKE ?";
        try (Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, "%" + str + "%"); 
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getInt("product_id"), rs.getString("name"), 
                        rs.getDouble("price"), rs.getInt("stock")));
            }
            
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
            
            return products;
        }
    }
    
}

