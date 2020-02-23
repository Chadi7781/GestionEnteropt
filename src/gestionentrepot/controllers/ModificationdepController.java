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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author HP
 */
public class ModificationdepController implements Initializable {

    @FXML
    private JFXTextField latt;
    @FXML
    private ComboBox<String> comboxdispo;

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
    
        
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/gestionentrepot/gui/geredepo.fxml"));
            Stage prStage = new Stage();
            Parent root;
            root = loader.load();
            Scene scene = new Scene(root);
            prStage.setScene(scene);
            GeredepoController irc = loader.getController();
            ServiceDepot sp = new ServiceDepot();
            int id = Integer.parseInt(irc.idl);
            System.out.println(id);
            adr.setText(sp.getAdresseDepotbyId(id));
            surface.setText(sp.getSurfaceDepotbyId(id).toString());
            prix1.setText(sp.getPrixDepotbyId(id).toString());
            
                    List<String> list = new ArrayList<>();
        list.add("Disponible");
        list.add("Non disponible");
        ObservableList obList = FXCollections.observableList(list);
        comboxdispo.getItems().clear();
        comboxdispo.setItems(obList);
        } catch (IOException ex) {
           
        } 
    }    

    @FXML
    private void mod(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/gestionentrepot/gui/geredepo.fxml"));
        Stage prStage = new Stage();
        Parent root;
        root = loader.load();
        Scene scene = new Scene(root);
        prStage.setScene(scene);
        GeredepoController irc = loader.getController();
        ServiceDepot sp = new ServiceDepot();
        int idl = Integer.parseInt(irc.idl);
        Depot p =new Depot();
       p.setSurface(Integer.parseInt(surface.getText()));
        p.setPrix(Integer.parseInt(prix1.getText()));
        p.setEtat(comboxdispo.getValue().toString());
        p.setAdr(adr.getText().toString());
        sp.modifier(p,idl);
        Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("succes");
   alert.setHeaderText("!!! Modification effectuer avec suucces !!!");
   alert.setContentText("succes");
   alert.showAndWait();
    

    }
      @FXML
    void gotoDashbord(ActionEvent event) throws IOException {
              Parent root = FXMLLoader.load(getClass().getResource("/gestionentrepot/gui/Dashboard.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();

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
    void gotoStock(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("/gestionentrepot/gui/Stock.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();   
    }
    
            @FXML
    void gotoDepot(ActionEvent event) throws IOException {
        
              Parent root = FXMLLoader.load(getClass().getResource("/gestionentrepot/gui/geredepo.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
 
    }
    
    }
    

