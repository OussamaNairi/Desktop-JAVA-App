/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Driver.MysqlConnection;
import Entities.Item;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nairi
 */
public class ItemDao {
    public ArrayList<Item> GetAllItems()
    {
    String sql="SELECT `Id`, `ItemCode`, `ItemName`, `Amount`, `ExpiaryDate`, `Ingredients`, `Status`FROM `ivf_item` ";
    
        MysqlConnection con=new MysqlConnection();
        Connection connect=con.getConnection();
        Statement statement=null;
        ArrayList<Item> items=new ArrayList<Item>();
        try{ statement=connect.createStatement();
        ResultSet rs=statement.executeQuery(sql);
        
        while(rs.next()){
        Item item=new Item();
        item.setId(rs.getInt("Id"));
        item.setItemCode(rs.getString("ItemCode"));
        item.setItemName(rs.getString("ItemName"));
        item.setAmount(rs.getInt("Amount"));
        item.setExpiaryDate(rs.getString("ExpiaryDate"));
        item.setIngredients(rs.getString("Ingredients"));
        items.add(item);
        }
        }
        catch(Exception ex){}
        finally{
        try {
            connect.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ItemDao.class.getName()).log(Level.SEVERE, null, ex);
        }
}
        
        return items;
    }
    
    
}
