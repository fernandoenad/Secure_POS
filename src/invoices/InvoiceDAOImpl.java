/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invoices;

import database.DBConnection;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author fernandoenad
 */
public class InvoiceDAOImpl implements InvoiceDAO {
    public boolean create(Invoice invoice){
        String query = "INSERT INTO invoices(total_quantity, total_cost, amt_paid, `change`, user_id, status, `datetime`) "
                + "VALUES(?, ?, ?, ?, ?, ?, NOW())";
        
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, invoice.getTotal_quantity());
            pstmt.setDouble(2, invoice.getTotal_cost());
            pstmt.setDouble(3, invoice.getAmt_paid());
            pstmt.setDouble(4, invoice.getChange());
            pstmt.setInt(5, invoice.getUser_id());
            pstmt.setString(6, invoice.getStatus());
            pstmt.executeUpdate();
            
            return true;
        } catch (SQLException e){
            e.printStackTrace();
            
            return false;
        }
    }
    
    public Invoice read_one(int invoice_id){
        Invoice invoice = null;
        String query = "SELECT * FROM invoices WHERE invoice_id = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, invoice_id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                invoice = new Invoice(rs.getInt("invoice_id"), 
                        rs.getInt("total_quantity"), 
                        rs.getDouble("total_cost"),
                        rs.getDouble("amt_paid"),
                        rs.getDouble("change"),
                        rs.getInt("user_id"),
                        rs.getString("status"),
                        rs.getString("datetime")
                );
            }
            return invoice;
        } catch (SQLException e){
            e.printStackTrace();
            return invoice;
        }
    }
    
    public ArrayList<Invoice> read_all(){
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
        String query = "SELECT * FROM invoices WHERE status LIKE ? ORDER BY datetime DESC";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setString(1, "Completed");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                invoices.add(new Invoice(rs.getInt("invoice_id"), 
                        rs.getInt("total_quantity"), 
                        rs.getDouble("total_cost"),
                        rs.getDouble("amt_paid"),
                        rs.getDouble("change"),
                        rs.getInt("user_id"),
                        rs.getString("status"),
                        rs.getString("datetime")
                ));
            }
            return invoices;
        } catch (SQLException e){
            e.printStackTrace();
            return invoices;
        }
    }
    
    
    public boolean update(int invoice_id, Invoice invoice){
        String query = "UPDATE invoices SET total_quantity = ?, "
                + "total_cost = ?, amt_paid = ?, `change` = ?, "
                + "status = ?, `datetime` = NOW() WHERE invoice_id = ?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, invoice.getTotal_quantity());
            pstmt.setDouble(2, invoice.getTotal_cost());
            pstmt.setDouble(3, invoice.getAmt_paid());
            pstmt.setDouble(4, invoice.getChange());
            pstmt.setString(5, invoice.getStatus());
            pstmt.setInt(6, invoice_id);
            pstmt.executeUpdate();
            
            return true;
        } catch(SQLException e){
            e.printStackTrace();
            
            return false;
        }
    }
    
    public ArrayList<Invoice> readInvoicesByUser(int user_id){
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
        String query = "SELECT * FROM invoices WHERE user_id = ? AND status LIKE ? ORDER BY datetime DESC";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setString(1, "Completed");
            pstmt.setInt(2, user_id);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                invoices.add(new Invoice(rs.getInt("invoice_id"), 
                        rs.getInt("total_quantity"), 
                        rs.getDouble("total_cost"),
                        rs.getDouble("amt_paid"),
                        rs.getDouble("change"),
                        rs.getInt("user_id"),
                        rs.getString("status"),
                        rs.getString("datetime")
                ));
            }
            return invoices;
        } catch (SQLException e){
            e.printStackTrace();
            return invoices;
        }
    }
    
    public Invoice read_last_insert(int user_id){
        Invoice invoice = null;
        String query = "SELECT * FROM invoices WHERE user_id = ? ORDER BY datetime DESC";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query)){
            pstmt.setInt(1, user_id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                invoice = new Invoice(rs.getInt("invoice_id"), 
                        rs.getInt("total_quantity"), 
                        rs.getDouble("total_cost"),
                        rs.getDouble("amt_paid"),
                        rs.getDouble("change"),
                        rs.getInt("user_id"),
                        rs.getString("status"),
                        rs.getString("datetime")
                );
            }
            return invoice;
        } catch (SQLException e){
            e.printStackTrace();
            return invoice;
        }
    }
}
