/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public  class DBConnect {
   
   static final String DB_URL = "jdbc:mysql://localhost:3306/gestion_entrepot";
   static final String USER = "root";
   static final String PASS = "";
   static Connection conn = null;
       static DBConnect myconnBD;

   //Statement stmt = null;
     DBConnect(){
       try{

           conn = DriverManager.getConnection(DB_URL,USER,PASS);
           System.out.println("connection reussite");
          //           String sql="SELECT  * from club";

           //Statement st = conn.createStatement();
          // ResultSet res =st.executeQuery(sql);
           //while(res.next()) {
             //  System.out.println("la per "+res.getInt("id") );
           
           
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
       }
   }
     
       public static DBConnect getInstance(){
        
        if(myconnBD == null)
         myconnBD =   new DBConnect();
           
        return myconnBD;
    }
    
     
   public  static Connection getConnection(){
            return conn;            
   }
  
   
}
    
    

