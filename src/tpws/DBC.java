/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpws;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Mr SOFIANE
 */
public class DBC {
    Connection con = null;
        public Connection getConnection(){
            try{
                String url = "jdbc:mysql://localhost:3306/gest";
                String user = "root";
                String pass = "root";
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver OK");
                con = DriverManager.getConnection(url,user,pass);
                System.out.println("Connexion OK");
            }catch(Exception e){
                e.printStackTrace();
            }
        return con;
            
        }    
    
}
