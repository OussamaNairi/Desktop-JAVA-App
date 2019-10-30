/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Driver.MysqlConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nairi
 */
public class UserDao {
    public boolean checkUserNameAndPassword(String Un,String Pass) throws SQLException{
    String sql="SELECT `Id`, `Usename`, `Password` FROM `ivf_user` WHERE UseName='"+Un+"' and Password='"+Pass+"'";
    boolean IsValid=false;
        MysqlConnection con=new MysqlConnection();
        Connection connect=con.getConnection();
        Statement statement=null;
        
        try{ statement=connect.createStatement();
        ResultSet rs=statement.executeQuery(sql);
        String UserName="";
        String Password="";
        while(rs.next()){
        IsValid=true;
        }
        }
        catch(Exception ex){}
        finally{
            connect.close();
            statement.close();}
        
        return IsValid;
    }
}
