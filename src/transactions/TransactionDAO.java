/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package transactions;

import java.util.ArrayList;
import products.Product;

public interface TransactionDAO {
    public boolean create(Transaction transaction);
    public Transaction read_one(int transaction_id);
    public ArrayList<Transaction> read_all();
    public boolean delete(int transaction_id);
    public ArrayList<Transaction> readTransactionsByUser(int user_id);
}
