/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import pidev.util.DBConnect;
import pidev.views.ReclamationServiceController;
import pidev.entity.Reclamation;
import pidev.entity.Utilisateur;

/**
 *
 * @author PC
 */
public class ReclamationService  implements IReclamationService{
        ObservableList<Reclamation>obList = FXCollections.observableArrayList();
               ObservableList<Utilisateur>obListUser = FXCollections.observableArrayList();
 

    private Connection con;
    private Statement st;
    private  ResultSet rs;
    
    private LineChart<String,Date>lineChart;

    public ReclamationService() {
        con= DBConnect.getInstance().getConnection();
    }
    
    
    @Override
    public void ajouterReclamation(Reclamation p) {
        PreparedStatement pst;
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());         
            String etat = "0";
            int  id =1235;
            try{
                
            String sql = "INSERT INTO reclamation (objet,description,etat,date,id)VALUES(?,?,?,?,?) ";
            pst = con.prepareStatement(sql);
            pst.setString(1, p.getObjet());
            pst.setString(2, p.getDescription());
            pst.setInt(3,p.getEtat());
            pst.setString(4, date);
            pst.setInt(5,id);
            pst.executeUpdate();
    
            
            
            } catch (Exception ex) {
                Logger.getLogger(ReclamationServiceController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
 
   @Override
    public void modifierReclamation(Reclamation p) {
        int id=0;
        int etat=0;
       
        String sql2="UPDATE reclamation SET objet=?,description=? WHERE id_rec=?";
        try{
            
             PreparedStatement pstmt = con.prepareStatement(sql2);
            
            pstmt.setString(1,p.getObjet());
            pstmt.setString(2,p.getDescription());
            pstmt.setInt(3,p.getId());
            pstmt.executeUpdate();
            pstmt.close();

            
       }catch (SQLException ex) {
           Logger.getLogger(ReclamationServiceController.class.getName()).log(Level.SEVERE, null, ex);
       }
        //
       
    
    }
           
       // showReclamations();
   @Override
    public ObservableList<Reclamation> getAllReclamation() {
        List<Reclamation> array= new ArrayList<>();
        ResultSet rs;//   obList.clear();
        String sql ="select * from reclamation  R "
                + "JOIN fos_user FU ON FU.id=R.id";

         try {
           
	    PreparedStatement st= con.prepareStatement(sql);
	    ResultSet res= st.executeQuery();
        

     while (res.next()) {        
             System.out.println("debut get");
               int id=res.getInt(1);
               String objet=res.getString(2);
               String description=res.getString(3);
               int etat = res.getInt(4);
               int iduser=res.getInt("id");
               String email=res.getString("email");
               System.out.println("fu user is ="+res.getString("email"));
                obList.add(new Reclamation(objet, description,id,etat,iduser,email));
                System.out.println("dattttt = "+obList);
                
     }
     st.close();
      } catch (SQLException ex) {
            
        }
         
         return obList;
     
    }

    @Override
    public int getNbrReclamation() {
        String sql="SELECT COUNT(*) FROM reclamation";
        ResultSet rs;
        int countIdRec=0;
        try {
            PreparedStatement st= con.prepareStatement(sql);
			ResultSet res= st.executeQuery(); 
                        while(res.next()) {
                           countIdRec= res.getInt(1);
                        }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return countIdRec;
    }

    @Override
    public void traiterReclamation(Reclamation p ) {
        
        
        String sql2="UPDATE reclamation SET etat=? WHERE id_rec=?";
        try{
            
             PreparedStatement pstmt = con.prepareStatement(sql2);
            
            pstmt.setInt(1,p.getEtat());
            pstmt.setInt(2,p.getId());
            pstmt.executeUpdate();
            pstmt.close();

            
       }catch (Exception ex) {
           Logger.getLogger(ReclamationServiceController.class.getName()).log(Level.SEVERE, null, ex);
       }

    }

    @Override
    public BarChart loadChart() {
        int nbr = getNbrReclamation();
         NumberAxis xAxis = new NumberAxis();
     CategoryAxis yAxis = new CategoryAxis();
      String itemA = "Attendance";
      String itemB = "CT_Marks";
      String itemC = "Assignment";
      String itemD = "Others";
     Statement statement = null;
     int i=1;
     int j=2;
  XYChart.Data<String, Number> data =  new XYChart.Data<String, Number>();
  Pane pane=new Pane();
  pane.setPrefSize(600, 500);
  BarChart<String,Number> bchart=new BarChart<String,Number>(yAxis, xAxis);
  bchart.setPrefSize(550, 450);
  bchart.setTitle("Summary");
     xAxis.setLabel("Values");
     xAxis.setTickLabelRotation(45);
     yAxis.setTickLabelRotation(45);
     yAxis.setLabel("Menus");
     XYChart.Series series1 = new XYChart.Series();
     XYChart.Series series2 = new XYChart.Series();
        try{
         String sql="select id_rec, from reclamation";
         ResultSet rset=statement.executeQuery(sql);
         while(rset.next()){
           XYChart.Data<String, Number> datax =  new XYChart.Data<String, Number>(rset.getString(i),nbr);
             System.out.println("nbr="+nbr);
             
           series2.getData().add(datax);
           series1.getData().add(datax);
          
          
         } i++;j++;
      
        }catch(Exception e){
        
        }
     bchart.getData().addAll(series1,series2);
     pane.getChildren().add(bchart);
    
   return bchart;
    }


    

}
    

