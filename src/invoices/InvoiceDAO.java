/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package invoices;

import java.util.ArrayList;

/**
 *
 * @author fernandoenad
 */
public interface InvoiceDAO {
    public boolean create(Invoice invoice);
    public Invoice read_one(int invoice_id);
    public ArrayList<Invoice> read_all();
    public boolean update(int invoice_id, Invoice invoice);
    public ArrayList<Invoice> readInvoicesByUser(int user_id);
}
