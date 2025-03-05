/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package products;

import java.util.ArrayList;

public interface ProductDAO {
    public boolean create(Product product);
    public Product read_one(int product_id);
    public ArrayList<Product> read_all();
    public boolean update(int product_id, Product product);
    public boolean delete(int product_id);
    public ArrayList<Product> search(String str);
}

