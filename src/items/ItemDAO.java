/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package items;

import java.util.ArrayList;

/**
 *
 * @author fernandoenad
 */
public interface ItemDAO {
    public boolean create(Item item);
    public boolean update(int item_id, Item item);
    public boolean delete(int item_id);
    public ArrayList<Item> readItemsByInvoice(int invoice_id);
}
