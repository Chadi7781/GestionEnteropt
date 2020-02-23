/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionentrepot.controllers;

import pidev.views.*;
import animatefx.animation.FadeIn;
import animatefx.animation.ZoomIn;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.net.URL;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import pidev.entity.Reclamation;
import pidev.entity.Vehicule;
import pidev.services.ReclamationService;
import pidev.services.VehiculeService;
import pidev.util.ZoomManager;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class MenuAdminController extends Application  implements Initializable  {

    @FXML
    private Circle btnClose;
    @FXML
    private StackPane stackPane;
    private JFXButton btn_stat;
    @FXML
    private JFXButton btn_vehicule;
    @FXML
    private BorderPane border_pane_admin;
    @FXML
    private Pane pnlVehicule;
    @FXML
    private JFXTextField txt_mat;
    @FXML
    private JFXTextField txt_marque;
    @FXML
    private JFXRadioButton radio_dispo;
    @FXML
    private JFXRadioButton radio_non_dispo;
    @FXML
    private JFXButton btn_add_v;
    
        ObservableList<Vehicule>obList ;

              Reclamation reclamation = new Reclamation();

     Vehicule vehicule = new Vehicule();

     private  JFXButton btn;
     private JFXButton btnSupprimer;
     private JFXToggleButton btnTraiter;
        TableColumn<Vehicule, Void> colBtn ;
        TableColumn<Vehicule, Void> colSuppBtn ;
        TableColumn<Reclamation, Void> colTraiterBtn ;
    

    @FXML
    private TableView<Vehicule> table;
   
    @FXML
    private JFXTextField txt_filter;
    @FXML
    private TableColumn<Vehicule, String> col_type;
    @FXML
    private TableColumn<Vehicule, String> col_etat;
    
      List list_vehicule_current = new ArrayList<>();

    
    //
    VehiculeService vehiculeService = new VehiculeService();
    ReclamationService reclamationService = new ReclamationService();
    
    //
    private Pane pnl_modif_v;
    @FXML
    private TextField tx_mod_objet;
    @FXML
    private TextArea txt_mod_desc;
    @FXML
    private Pane pnl_liste_v;
    @FXML
    private JFXButton btn_liste_vehicule;
    @FXML
    private Pane pnlModif;
    @FXML
    private JFXButton btnModifierValider;
    @FXML
    private JFXButton btnModifierAnnuler;
    @FXML
    private ImageView btnBackListV;
    private Label label;
    @FXML
    private ImageView btnBack;
    @FXML
    private TableColumn<?, ?> col_objet;
    @FXML
    private TableColumn<?, ?> col_description;
    @FXML
    private JFXTextField txt_filter1;
    @FXML
    private Pane pnl_liste_reclamations;
    @FXML
    private Hyperlink lien_consulter_stat;
    @FXML
    private JFXButton btn_cons_rec;
    @FXML
    private TableView<Reclamation> table_consulter_rec;
    
        ObservableList<Reclamation>obListRec ;
    @FXML
    private Pane pnlStat;
    @FXML
    private TableColumn<?, ?> col_id_rec;
    @FXML
    private TableColumn<?, ?> col_user_email;



    



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
              
        
       colBtn=new TableColumn<>("Modifier");
       table.getColumns().add(colBtn);
       colTraiterBtn=new TableColumn<>("Traiter");
       table_consulter_rec.getColumns().add(colTraiterBtn);
         colSuppBtn = new TableColumn<>("Supprimer");
            table.getColumns().add(colSuppBtn);                      
                     
                     

                     
        

                       //TableView
       // tableview = new TableView();
       vehiculeService = new VehiculeService();
       obList= vehiculeService.getVehicule();
       table.setItems(obList);
       
        //Main Scene
       // Scene scene = new Scene(tableview);        

        //stage.setScene(scene);x²x²xx
        //stage.show();
        

        
    }    


    @FXML
    private void HandleActionStatistique(ActionEvent event) {
        pnl_liste_reclamations.setVisible(false);
             new ZoomIn(pnlStat).play();
            pnlStat.toFront();
            System.out.println("click");
            //stage.setTitle("Line Chart Sample");
	// defining the axes
	final NumberAxis xAxis = new NumberAxis();
	final NumberAxis yAxis = new NumberAxis();
	xAxis.setAutoRanging(true);
	xAxis.setForceZeroInRange(false);
	yAxis.setAutoRanging(true);
	yAxis.setForceZeroInRange(false);
	xAxis.setLabel("Number of Month");
	// creating the chart
	final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

	lineChart.setTitle("Taux des reclamation par mois, 2020");
	// defining a series
	final XYChart.Series series = new XYChart.Series();
	series.setName("Bienvenue");
	// populating the series with data
	//
        
        
        series.getData().add(new XYChart.Data(1, 23));
	series.getData().add(new XYChart.Data(2, 14));
	series.getData().add(new XYChart.Data(3, 15));
	series.getData().add(new XYChart.Data(4, 24));
	series.getData().add(new XYChart.Data(5, 34));
	series.getData().add(new XYChart.Data(6, 36));
	series.getData().add(new XYChart.Data(7, 22));
	series.getData().add(new XYChart.Data(8, 45));
	series.getData().add(new XYChart.Data(9, 43));
	series.getData().add(new XYChart.Data(10, 17));
	series.getData().add(new XYChart.Data(11, 29));
	series.getData().add(new XYChart.Data(12, 25));

	// DO NOT ADD DATA TO CHART
	// bc.getData().addAll(series1, series2, series3);
	stackPane.getChildren().add(lineChart);
	
	new ZoomManager(stackPane, lineChart, series);
        
        
            
 

        
    }

    @FXML
    private void HandleActionButtonAjout(ActionEvent event) {
         int matricule=Integer.valueOf(txt_mat.getText().length());
         
         String marque = txt_marque.getText().toString();
         String etat ="";
         if(radio_dispo.isSelected()) {
             etat = radio_dispo.getText();
         }
         
         if(radio_non_dispo.isSelected()) {
             etat = radio_non_dispo.getText();
         }
         //Ajouter vehicule
          if(event.getSource().equals(btn_add_v)) {
                     vehicule = new Vehicule(matricule,marque,etat);
                     vehiculeService=new VehiculeService();
                     vehiculeService.ajouterVehicule(vehicule);
                     System.out.println("add");
                }

        
             //fin ajout vehicule
             
        
    }

    @FXML
    private void HandleActionButtonAffiche(Event event) {
        if(event.getSource().equals(btn_liste_vehicule)) {
            pnl_liste_v.setVisible(true);
            new ZoomIn(pnl_liste_v).play();
            pnl_liste_v.toFront();
      

            

            afficherVehicules();

            addButtonModifToTable();
            
       
            addButtonDeleteToTable();
        }
        else if(event.getSource().equals(btn_cons_rec)) {
            System.out.println("hey");
            new ZoomIn(pnl_liste_reclamations).play();
            pnl_liste_reclamations.toFront();
             afficherReclamation();
             addButtonTraiterToTable();

            
      
            
        }

    }
    
    public void afficherReclamation() {
        obListRec = reclamationService.getAllReclamation();

            table.refresh();
            obListRec.clear();

            obListRec   = reclamationService.getAllReclamation();
             col_objet.setCellValueFactory(new PropertyValueFactory<>("objet"));
               col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
               col_id_rec.setCellValueFactory(new PropertyValueFactory<>("id_rec"));
               col_user_email.setCellValueFactory(new PropertyValueFactory<>("email"));

               System.out.println("table contain ="+obListRec);
            table_consulter_rec.setItems(obListRec);
              System.out.println("here we = "+obListRec);

            



    }
    public void afficherVehicules() {
        
            obList   = vehiculeService.getVehicule();

            table.refresh();
            obList.clear();

            obList   = vehiculeService.getVehicule();
             col_type.setCellValueFactory(new PropertyValueFactory<>("marque"));
               col_etat.setCellValueFactory(new PropertyValueFactory<>("etat"));
            table.setItems(obList);
              System.out.println("here we = "+obList);
    }
      public void addButtonModifToTable() {
           


        Callback<TableColumn<Vehicule, Void>, TableCell<Vehicule, Void>> cellFactory = new Callback<TableColumn<Vehicule, Void>, TableCell<Vehicule, Void>>() {
            @Override
            public TableCell<Vehicule, Void> call(final TableColumn<Vehicule, Void> param) {

                final TableCell<Vehicule, Void> cell = new TableCell<Vehicule, Void>() {


                    { 

                        btn = new JFXButton("Modifier");

                        btn.setOnAction((ActionEvent event) -> {
                            
                             
                              new ZoomIn(pnlModif).play();
                              pnlModif.toFront();
                              vehicule = table.getSelectionModel().getSelectedItem();
                              tx_mod_objet.setText(String.valueOf(vehicule.getMat()));
                              
                              txt_mod_desc.setText(vehicule.getEtat());

                              
                                                                
                            
                        });
                        
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);  
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;    
            }
        };

        colBtn.setCellFactory(cellFactory);


        
        
        
   
      }
      
         public void addButtonDeleteToTable() {
              


        Callback<TableColumn<Vehicule, Void>, TableCell<Vehicule, Void>> cellFactory = new Callback<TableColumn<Vehicule, Void>, TableCell<Vehicule, Void>>() {
            @Override
            public TableCell<Vehicule, Void> call(final TableColumn<Vehicule, Void> param) {

                final TableCell<Vehicule, Void> cell = new TableCell<Vehicule, Void>() {


                    { 

                        btnSupprimer = new JFXButton("Supprimer");
                         btnSupprimer = new JFXButton("Supprimer");
                        btnSupprimer.setOnAction((ActionEvent event) -> {
                            
                             
                              vehicule = table.getSelectionModel().getSelectedItem();
                              showConfirmation(vehicule);
                              
                        });

                   
                        
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);  
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnSupprimer);
                        }
                    }
                };
                return cell;    
            }
        };

        colSuppBtn.setCellFactory(cellFactory);


        
        
        
   
      }
         
      public void addButtonTraiterToTable() {
        Callback<TableColumn<Reclamation, Void>, TableCell<Reclamation, Void>> cellFactory = new Callback<TableColumn<Reclamation, Void>, TableCell<Reclamation, Void>>() {
            @Override
            public TableCell<Reclamation, Void> call(final TableColumn<Reclamation, Void> param) {

                final TableCell<Reclamation, Void> cell = new TableCell<Reclamation, Void>() {


                    { 

                        btnTraiter = new JFXToggleButton();

                        btnTraiter.selectedProperty().addListener(((observable, oldValue, newValue) -> {
                            if(newValue==true){
                              reclamation = table_consulter_rec.getSelectionModel().getSelectedItem();
                                      reclamation.setEtat(1);
                                      
                                      
                                      //Send notification
                              Notifications notificationBuild = Notifications.create()
                                      .title("Traitement Reclamation")
                                      .text("Traitement de reclamation est envoyé au client avec succes")
                                      .graphic(null)
                                      .hideAfter(Duration.seconds(5))
                                      .position(Pos.CENTER)
                                      .onAction(new EventHandler<ActionEvent>() {
                                  @Override
                                  public void handle(ActionEvent event) {
                                      System.out.println("click here");
                                  }
                                  
                              });
                              notificationBuild.show();
                                      
                                      

                            reclamationService.traiterReclamation(reclamation);
                            System.out.println(reclamation.getId());
                            }
                                                   
                        
                            }));
                         
                              
                                                                
                            
                     
                        
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);  
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btnTraiter);
                        }
                    }
                };
                return cell;    
            }
        };

        colTraiterBtn.setCellFactory(cellFactory);


        
        
        
   
      }
      


    @FXML
    private void HandleActionVehicule(ActionEvent event) {
        if(event.getSource().equals(btn_vehicule)) {
              new ZoomIn(pnlVehicule).play();
            pnlVehicule.toFront();
            pnlModif.setVisible(false);
            pnl_liste_v.setVisible(false);
        }
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        vehiculeService= new  VehiculeService();
       obList= vehiculeService.getVehicule();
       table.setItems(obList);  
       
       reclamationService = new ReclamationService();
       obListRec =reclamationService.getAllReclamation();
       table_consulter_rec.setItems(obListRec);
    }

    @FXML
    private void handleButtonValidateAction(ActionEvent event) {
    }

    @FXML
    private void handleMouseEvent(MouseEvent event) {
          if(event.getSource() == btnClose) {
            System.exit(0);
        }
        else if(event.getSource().equals(btnBackListV)) {
            new FadeIn(pnl_liste_v).play();
            pnl_liste_v.toFront();
        }   
     
        
    }
    
    private void showConfirmation(Vehicule vehicule) {
        
 
      Alert alert = new Alert(AlertType.CONFIRMATION);
      alert.setTitle("Suppression");
      alert.setHeaderText("Voullez vous vraiment supprimer??");
      alert.setContentText("La vehicule est tres efficace");
 
      // option != null.
      Optional<ButtonType> option = alert.showAndWait();
 
      if (option.get() == null) {
         this.label.setText("pas selection!");
      } else if (option.get() == ButtonType.OK) {
          vehiculeService.supprimerVehicule(vehicule);
          obList.clear();
          vehiculeService.getVehicule();
      } else if (option.get() == ButtonType.CANCEL) {
         this.label.setText("Exit!");
      } else {
         this.label.setText("-");
      }
   }



      


    
    

}

