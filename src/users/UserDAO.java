/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package users;

import java.util.ArrayList;

public interface UserDAO {
    public boolean create(User user);
    public User read_one(int user_id);
    public ArrayList<User> read_all();
    public boolean update(User user);
    public boolean delete(int user_id);
    public ArrayList<User> search(String str);
}

