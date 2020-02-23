/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import pidev.entity.Reclamation;
import pidev.entity.Vehicule;
import pidev.util.DBConnect;
import pidev.views.ReclamationServiceController;

/**
 *
 * @author PC
 */
public class VehiculeService  implements IVehiculeService{

       ObservableList<Vehicule>obList = FXCollections.observableArrayList();

    private Connection con;
    private Statement st;
    private  ResultSet rs;
    String mat;

    public VehiculeService() {
        con= DBConnect.getInstance().getConnection();
    }
    
    
    @Override
    public void ajouterVehicule(Vehicule v) {
        PreparedStatement pst;
         int n=0;

        
             try{
                
            pst= con.prepareStatement("insert into vehicule values ( ? , ? , ?  )");
			pst.setInt(1,v.getMat());
			pst.setString(2,v.getMarque());
			pst.setString(3,v.getEtat());
			
			n= pst.executeUpdate();
			pst.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
          
            
    }
    
    @Override
    public void modifierVehicule(Vehicule v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerVehicule(Vehicule v) {
        int n=0;
		PreparedStatement st;
		try {
			
			
			st= con.prepareStatement("DELETE FROM `vehicule` WHERE `mat`=?");
			
			st.setInt(1,v.getMat());
			
			
			n= st.executeUpdate();
			st.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
    }

    @Override
    public ObservableList<Vehicule> getVehicule() {
           List<Vehicule> array= new ArrayList<>();
        ResultSet rs;//   obList.clear();

         try {
           
	    PreparedStatement st= con.prepareStatement("select * from vehicule");
	    ResultSet res= st.executeQuery();
        

     while (res.next()) {        
         System.out.println("hh");
               int mat=res.getInt("mat");
               String type=res.getString("marque");
               String etat = res.getString("etat");
                obList.add(new Vehicule(mat, type,etat));
                                System.out.println("data = "+obList);

                
     }
     st.close();
      } catch (SQLException ex) {
            
        }
         
         return obList;
     
    }

    @Override
    public String getVehiculeById() {

         try {
           
	    PreparedStatement st= con.prepareStatement("select mat from vehicule");
    	    ResultSet res= st.executeQuery();
    

     while (res.next()) {  
         mat=res.getString(1);
         System.out.println(mat);
         
         
               
                
     }
     	   rs= st.executeQuery();

     st.close();
      } catch (SQLException ex) {
            ex.printStackTrace();
        }
         
    
    

   
	return mat;	


    }
} 