/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author asus
 */
public class DataSource {
    final static String URL = "jdbc:mysql://localhost:3306/SPORTify";
    final static String LOGIN = "root";
    final static String PWD = "";
    static DataSource instance ;
    private Connection cnx;
    
   private DataSource() {
        
        try {
            cnx = DriverManager.getConnection(URL, LOGIN, PWD);
            System.out.println("cnx etablie  ");
        } catch (SQLException e) {
             System.out.println("erreur de cnx ");    
      

        }
    }
    
   public static DataSource getInstance() {
        if (instance == null)
        {
            instance = new DataSource();
        }
        return instance;
    }
    public  Connection getConnection(){
        return cnx;
    }
    
}


