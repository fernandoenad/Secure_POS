/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package invoices;

/**
 *
 * @author fernandoenad
 */
public class Invoice {
    private int invoice_id;
    private int total_quantity;
    private double total_cost;
    private double amt_paid;
    private double change;
    private int user_id;
    private String status;
    private String datetime;

    public Invoice(int invoice_id, int total_quantity, double total_cost, double amt_paid, double change, int user_id, String status, String datetime) {
        this.invoice_id = invoice_id;
        this.total_quantity = total_quantity;
        this.total_cost = total_cost;
        this.amt_paid = amt_paid;
        this.change = change;
        this.user_id = user_id;
        this.status = status;
        this.datetime = datetime;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public int getTotal_quantity() {
        return total_quantity;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public double getAmt_paid() {
        return amt_paid;
    }

    public double getChange() {
        return change;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getStatus() {
        return status;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public void setTotal_quantity(int total_quantity) {
        this.total_quantity = total_quantity;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }

    public void setAmt_paid(double amt_paid) {
        this.amt_paid = amt_paid;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
    
    
    
}
