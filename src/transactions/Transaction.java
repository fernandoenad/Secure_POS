/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transactions;

public class Transaction {
    private int transaction_id;
    private int product_id;
    private int quantity;
    private double total_price;
    private int user_id;
    private String date;

    public Transaction(int transaction_id, int product_id, int quantity, 
            double total_price, int user_id, String date) {
        this.transaction_id = transaction_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.total_price = total_price;
        this.user_id = user_id;
        this.date = date;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal_price() {
        return total_price;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getDate() {
        return date;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setDate(String date) {
        this.date = date;
    }   
}
