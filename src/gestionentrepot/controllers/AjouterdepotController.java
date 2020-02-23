package gestionentrepot.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jfoenix.controls.JFXTextField;
import gestionentrepot.enteties.Depot;
import gestionentrepot.service.ServiceDepot;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class AjouterdepotController implements Initializable {

    @FXML
    private JFXTextField latt;
    @FXML
    private JFXTextField adr;
    @FXML
    private JFXTextField surface;
    @FXML
    private JFXTextField log;
    @FXML
    private JFXTextField prix1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void mod(ActionEvent event) {
         Depot p = new Depot();
         p.setAdr(adr.getText());
         p.setSurface(Integer.valueOf(surface.getText()));
         p.setPrix(Integer.valueOf(prix1.getText()));
        ServiceDepot sp = new   ServiceDepot();
   
   sp.ajouter(p);
   Alert alert = new Alert (Alert.AlertType.INFORMATION);
   alert.setTitle("succes");
   alert.setHeaderText(null);
   alert.setContentText("!!!succes !!!");
   alert.showAndWait();
    }
        @FXML
    void gotoEmploye(ActionEvent event) throws IOException {
              Parent root = FXMLLoader.load(getClass().getResource("/gestionentrepot/gui/GererEmp.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();

    }

    @FXML
    void gotodashbord(ActionEvent event) throws IOException {
                
              Parent root = FXMLLoader.load(getClass().getResource("/gestionentrepot/gui/Dashboard.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();

    }

    
            @FXML
    void gotodepot(ActionEvent event) throws IOException {
        
              Parent root = FXMLLoader.load(getClass().getResource("/gestionentrepot/gui/geredepo.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
 
    }
    
        @FXML
    void gotoStock(ActionEvent event) throws IOException {
        
              Parent root = FXMLLoader.load(getClass().getResource("/gestionentrepot/gui/Stock.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
 
    }
    
}
