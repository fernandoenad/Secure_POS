/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package items;

/**
 *
 * @author fernandoenad
 */
public class Item {
    private int item_id;
    private int invoice_id;
    private int product_id;
    private int quantity;

    public Item(int item_id, int invoice_id, int product_id, int quantity) {
        this.item_id = item_id;
        this.invoice_id = invoice_id;
        this.product_id = product_id;
        this.quantity = quantity;
    }

    public int getItem_id() {
        return item_id;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
