package gestionentrepot.controllers;

import com.gluonhq.charm.glisten.control.TextField;
import gestionentrepot.enteties.USER;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GererEmp {
	ControlEmploye control = new ControlEmploye();

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TableView<USER> Tableau;

	@FXML
	private TableColumn<USER, String> ID_Emp;

	@FXML
	private TableColumn<USER, String> Nom;

	@FXML
	private TableColumn<USER, String> Prenom;

	@FXML
	private TableColumn<USER, Date> Dare_naissance;

	@FXML
	private TableColumn<USER, String> adresse;

	@FXML
	private TableColumn<USER, String> Num_Tel;

	@FXML
	private TableColumn<USER, String> Role;

	@FXML
	private TextField RechercherEmp;

	@FXML
	private Button Bt_Ajouter;

	@FXML
	private Button Bt_Modifier;

	@FXML
	private Button Bt_Supprimer;

	@FXML
	private Button Bt_Quitter;

	@FXML
	private Circle btnClose;

	@FXML
	private Button Bt_Dashboard;

	@FXML
	private Button Bt_Emp;

	@FXML
	private Button Bt_Stock;

	@FXML
	private Circle btnClose1;

	@FXML
	private Button Bt_Dashboard1;

	@FXML
	private Button Bt_Emp1;

	@FXML
	private Button Bt_Stock1;
        @FXML
        private Text alertRechere;

	ObservableList<USER> users = FXCollections.observableArrayList();
	ObservableList<USER> allusers;
	ObservableList<USER> selectedusers;

	@FXML
	void AjouterEmployer(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/gestionentrepot/gui/AjouterEmp.fxml"));
		Scene scene = new Scene(root);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(scene);
		stage.show();

	}

	@FXML
	void ModifierEmployer(ActionEvent event) throws IOException {
            FXMLLoader loader  = new FXMLLoader();
            loader.setLocation(getClass().getResource("/gestionentrepot/gui/ModifierEmp.fxml"));
            Parent root = loader.load();
	    Scene scene = new Scene(root);
            ModifierEmp modifier = loader.getController();
            modifier.initdata((USER) Tableau.getSelectionModel().getSelectedItems().get(0));
	    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	    stage.setScene(scene);
	    stage.show();
            

	}

	@FXML
	void SearchEmployer(ActionEvent event) {
            USER u = new USER();
            u.setNom(RechercherEmp.getText().toString().toLowerCase());
            if (!control.ControleNOM(u)){
                alertRechere.setText("Nom invalide");
            }
            	users.clear();
		List<USER> listemps = control.getUnEmployenom(u);
		if (listemps != null ) {
                    if (!listemps.isEmpty()) {
		    for (int i = 0; i < listemps.size(); i++) {
			users.add(listemps.get(i));
                    }
                    }
                    Tableau.setItems(users);
                }
        }

	@FXML
	void SupprimerEmployer(ActionEvent event) {
		selectedusers = Tableau.getSelectionModel().getSelectedItems();
		if (selectedusers.size() > 0) {
			for (USER u : selectedusers)
				control.SupprimerUnEmploye(u);
			users.clear();
			List<USER> listemps = control.AfficheToutEmploye();
			for (int i = 0; i < listemps.size(); i++) {
				users.add(listemps.get(i));
			}
			Tableau.setItems(users);
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Gestion entropôt");
			alert.setHeaderText("Suppression des l'employés");
			alert.setContentText("Employer supprimé avec succès !");
			alert.showAndWait();

		}
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
	void handleMouseEvent(MouseEvent event) {

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

    

	@FXML
	void initialize() {
		assert Tableau != null : "fx:id=\"Tableau\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert ID_Emp != null : "fx:id=\"ID_Emp\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert Nom != null : "fx:id=\"Nom\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert Prenom != null : "fx:id=\"Prenom\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert Dare_naissance != null : "fx:id=\"Dare_naissance\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert adresse != null : "fx:id=\"adresse\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert Num_Tel != null : "fx:id=\"Num_Tel\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert Role != null : "fx:id=\"Role\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert RechercherEmp != null : "fx:id=\"RechercherEmp\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert Bt_Ajouter != null : "fx:id=\"Bt_Ajouter\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert Bt_Modifier != null : "fx:id=\"Bt_Modifier\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert Bt_Supprimer != null : "fx:id=\"Bt_Supprimer\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert Bt_Quitter != null : "fx:id=\"Bt_Quitter\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert Bt_Dashboard != null : "fx:id=\"Bt_Dashboard\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert Bt_Emp != null : "fx:id=\"Bt_Emp\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert Bt_Stock != null : "fx:id=\"Bt_Stock\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert btnClose1 != null : "fx:id=\"btnClose1\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert Bt_Dashboard1 != null : "fx:id=\"Bt_Dashboard1\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert Bt_Emp1 != null : "fx:id=\"Bt_Emp1\" was not injected: check your FXML file 'GererEmp.fxml'.";
		assert Bt_Stock1 != null : "fx:id=\"Bt_Stock1\" was not injected: check your FXML file 'GererEmp.fxml'.";
		List<USER> listemps = control.AfficheToutEmploye();
		if (!listemps.isEmpty()) {
			for (int i = 0; i < listemps.size(); i++) {
				users.add(listemps.get(i));
			}
		}
		ID_Emp.setCellValueFactory(new PropertyValueFactory<USER, String>("cin"));
		Nom.setCellValueFactory(new PropertyValueFactory<USER, String>("nom"));
		Prenom.setCellValueFactory(new PropertyValueFactory<USER, String>("prenom"));
		Dare_naissance.setCellValueFactory(new PropertyValueFactory<USER, Date>("dateNaissance"));
		adresse.setCellValueFactory(new PropertyValueFactory<USER, String>("adresse"));
		Num_Tel.setCellValueFactory(new PropertyValueFactory<USER, String>("numtel"));
		Role.setCellValueFactory(new PropertyValueFactory<USER, String>("mission"));
		Tableau.setItems(users);
	}
}