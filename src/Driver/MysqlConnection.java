/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author nairi
 */
public class MysqlConnection {
    public Connection connection = null ;
         public Connection getConnection(){
         System.out.println("MySQL Testing");
               try { Class.forName("com.mysql.cj.jdbc.Driver");
                 connection = DriverManager.getConnection("jdbc:mysql://localhost/ivf_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
                 } 
               catch (Exception ex) {
                   System.out.println("connection Error");
                   ex.printStackTrace();
                   }
               finally {
                   if (connection != null) {
                       System.out.println("connection success");}
                   else {
                   System.out.println("connection Failed!");
                   }
                   }
               
               return connection;
               }
    
     }
    
