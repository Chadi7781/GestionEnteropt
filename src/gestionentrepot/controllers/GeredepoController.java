package gestionentrepot.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import gestionentrepot.enteties.Depot;
import gestionentrepot.enteties.USER;
import gestionentrepot.service.ServiceDepot;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class GeredepoController {
public static String idl;
    @FXML
    private TableColumn<Depot, String> adr;
    @FXML
    private TableColumn<Depot, String> ete;
    @FXML
    private TableColumn<Depot, Integer> surf;
    @FXML
    private TableColumn<Depot, Integer> id;
    @FXML
    private TableView<Depot> table;
    ServiceDepot depot = new ServiceDepot();
ObservableList<Depot>observableList;

    /**
     * Initializes the controller class.
     */
    void initialize() {
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'geredepo.fxml'.";
        assert adr != null : "fx:id=\"adr\" was not injected: check your FXML file 'geredepo.fxml'.";
        assert ete != null : "fx:id=\"ete\" was not injected: check your FXML file 'geredepo.fxml'.";
        assert surf != null : "fx:id=\"surf\" was not injected: check your FXML file 'geredepo.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'geredepo.fxml'.";
        observableList = depot.afficher();
        adr.setCellValueFactory(new PropertyValueFactory<>("adr"));
        surf.setCellValueFactory(new PropertyValueFactory<>("surface"));
        
        ete.setCellValueFactory(new PropertyValueFactory<>("Etat"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
       
        table.setItems(observableList);
        table.refresh();
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
    private void mod(ActionEvent event) throws IOException {
        if (table.getSelectionModel().getSelectedItem()!=null){
            idl=table.getSelectionModel().getSelectedItem().getId().toString();
		Parent root = FXMLLoader.load(getClass().getResource("/gestionentrepot/gui/Modificationdep.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();
    }
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
    private void supp(ActionEvent event) {
        ServiceDepot sp = new ServiceDepot();
   if (table.getSelectionModel().getSelectedItem()!=null){
        sp.supprimer(table.getSelectionModel().getSelectedItem().getId());
        table.refresh();
          Alert alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle("succes");
   alert.setHeaderText("!!! Suppression effectuer avec suucces !!!");
   alert.setContentText("succes");
   observableList.clear();
   observableList = depot.afficher();
   table.setItems(observableList);
   alert.showAndWait();
   table.refresh();
    }
    }

    @FXML
    private void Ajouter(ActionEvent event) throws IOException {
              Parent root = FXMLLoader.load(getClass().getResource("/gestionentrepot/gui/Ajouterdepot.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
    }
}
