package gestionentrepot.controllers;

import animatefx.animation.ZoomIn;
import com.gluonhq.charm.glisten.control.TextField;
import com.jfoenix.controls.JFXButton;
import gestionentrepot.service.ServiceDepot;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.chart.XYChart;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Dashboard {

    @FXML
    private StackedBarChart<?, ?> StackBar;

    @FXML
    private PieChart PieChart;

    @FXML
    private Button Bt_Dashboard2;

    @FXML
    private Button Bt_Emp2;

    @FXML
    private Button Bt_Stock2;

    @FXML
    private TextField Moyenne_Age_Input;
    ControlEmploye econtroleemploye = new ControlEmploye();
    ServiceDepot servicedep = new ServiceDepot();
    @FXML
    private Button Bt_Stock21;
    @FXML
    private Button btn_cons_rec;


    @FXML
          void gotoEmploye(ActionEvent event) throws IOException {
              Parent root = FXMLLoader.load(getClass().getResource("/gestionentrepot/gui/GererEmp.fxml"));
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
    
        @FXML
    void gotoStock(ActionEvent event) throws IOException {
        
              Parent root = FXMLLoader.load(getClass().getResource("/gestionentrepot/gui/Stock.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();
 
    }


    void handleMouseEvent(MouseEvent event) {

    }

    
    
    void initialize() throws SQLException {
        assert Bt_Dashboard2 != null : "fx:id=\"Bt_Dashboard2\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert Bt_Stock2 != null : "fx:id=\"Bt_Stock2\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert Bt_Emp2 != null : "fx:id=\"Bt_Emp2\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert StackBar != null : "fx:id=\"StackBar\" was not injected: check your FXML file 'Dashboard.fxml'.";
        assert PieChart != null : "fx:id=\"PieChart\" was not injected: check your FXML file 'Dashboard.fxml'.";
        
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Depot non disponible", (servicedep.findAllDepotsNondispo().size())), new PieChart.Data("Depot disponible", (servicedep.findAllDepotsdispo().size())) );
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Depot");
        PieChart.setData(pieChartData);
         XYChart.Series dataSeries1 = new XYChart.Series();
         dataSeries1.setName("Nombre des employés");

         double totale = econtroleemploye.getNbrOuvrier() +econtroleemploye.getNbrIngenieur()+econtroleemploye.getNbrLivreur()+econtroleemploye.getNbrTechnicien();
         dataSeries1.getData().add(new XYChart.Data("Ouvrier", econtroleemploye.getNbrOuvrier()));
         dataSeries1.getData().add(new XYChart.Data("% des ouvrier",(econtroleemploye.getNbrOuvrier()/totale)*100));
         dataSeries1.getData().add(new XYChart.Data("Ingenieur", econtroleemploye.getNbrIngenieur()));
         dataSeries1.getData().add(new XYChart.Data("% des ingenieur", (econtroleemploye.getNbrIngenieur()/totale)*100));
         dataSeries1.getData().add(new XYChart.Data("Livreur", econtroleemploye.getNbrLivreur()));
         dataSeries1.getData().add(new XYChart.Data("% des livreurs", (econtroleemploye.getNbrLivreur()/totale)*100));
         dataSeries1.getData().add(new XYChart.Data("Technicien", econtroleemploye.getNbrTechnicien()));
         dataSeries1.getData().add(new XYChart.Data("% des techniciens", (econtroleemploye.getNbrTechnicien()/totale)*100));
         StackBar.getData().add(dataSeries1);
         DecimalFormat df = new DecimalFormat("0.00");
        Moyenne_Age_Input.setText(String.valueOf(df.format(econtroleemploye.getMoyenneAge()/totale)));
        

    }

    @FXML
    private void gotoReclamation(ActionEvent event) throws IOException {
                     
             
                       
              Parent root = FXMLLoader.load(getClass().getResource("/gestionentrepot/gui/menu_admin.fxml"));
              Scene scene = new Scene(root);
              Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
              stage.setScene(scene);
              stage.show();              
                                  
       
 
    }

    
}
