package gestionentrepot.controllers;

import com.gluonhq.charm.glisten.control.TextField;
import gestionentrepot.enteties.USER;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AjouterEmp {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField Cin_Input;

	@FXML
	private TextField Nom_Input;

	@FXML
	private TextField Prenom_Input;

	@FXML
	private TextField Adresse_Input;

	@FXML
	private TextField Email_Input;

	@FXML
	private DatePicker DateNaissance_Input;

	@FXML
	private ImageView Photo_Input;

	@FXML
	private Button button_Submit;

	@FXML
	private ComboBox<?> Combomission;

	@FXML
	private Circle btnClose;

	@FXML
	private Button Bt_Dashboard;

	@FXML
	private Button Bt_Emp;

	@FXML
	private Button Bt_Stock;

	@FXML
    private TextField Téléphoneinput;

	@FXML
	private Text alertNom;

	@FXML
	private Text alertCIN;

	@FXML
	private Text alertPrenom;

	@FXML
	private Text alertAdresse;

	@FXML
	private Text alertDatenaissance;

	@FXML
	private Text alertEmail;

	@FXML
	private Text alertRole;

	@FXML
	private Text alertTel;

	@FXML
    void handleButtonSubmitAction(ActionEvent event) {
        ControlEmploye control = new ControlEmploye();
        String nom = Nom_Input.getText().toString().toLowerCase();
        nom.length();
        String prenom = Prenom_Input.getText().toString().toLowerCase();
        String email = Email_Input.getText().toString().toLowerCase();
        String adresse = Adresse_Input.getText().toString().toLowerCase();
        String cin = Cin_Input.getText().toString().toLowerCase();
        Date datenaissance = null;
        if (DateNaissance_Input.getValue() != null) {
            datenaissance = Date.valueOf(DateNaissance_Input.getValue());
        }
        String mission = "";
        if (Combomission.getSelectionModel().getSelectedItem() != null){
        mission = Combomission.getSelectionModel().getSelectedItem().toString();
        }
        String numtel = Téléphoneinput.getText().toString().toLowerCase();
        Alert alert = new Alert(AlertType.INFORMATION);          
        alert.setTitle("Gestion entropôt");
        alert.setHeaderText("Ajout de l'employé");
        Boolean retourstr= true;
        USER u = new USER(nom, prenom, email, cin, adresse, datenaissance, "EMPLOYE", mission,numtel);
        if (!control.ControleCIN(u)){
            alertCIN.setText("CIN non valable. ");
            retourstr=false;
        }
        if (!control.ControleROLE(u)){
            alertRole.setText("Role non valable. ");
            retourstr=false;
        }
        
        if (!control.ControleTELNUMBER(u)){
            alertTel.setText("Numero de telephone non valable. ");
            retourstr=false;
        }
        if (!control.ControleEmail(u)){
            alertEmail.setText("Email non valable. ");
            retourstr=false;
        }
        if (!control.ControleNOM(u)){
            alertNom.setText("Nom non valable. ");
            retourstr=false;
        }
        if (!control.ControlePRENOM(u)){
            alertPrenom.setText("Prenom non valable. ");
            retourstr=false;
        }
        if (!control.ControleADRESSE(u)){
            alertAdresse.setText("Adresse non valable. ");
            retourstr=false;
        }
        if (!control.ControleDate(u)){
            alertDatenaissance.setText("Date naissance non valable. ");
            retourstr=false;
        }
        if (retourstr==true) {
        String ajoutEmployer = control.AjouterEmploye(u);
        if (ajoutEmployer.equals("")){
            alert.setContentText("Employer ajouté avec succès !");
            alert.showAndWait();
        }
        else {
            alert.setContentText(ajoutEmployer);
            alert.showAndWait();
        }
    }
    }

	@FXML
	void handleMouseEvent(MouseEvent event) {

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


	@FXML
    void initialize() throws FileNotFoundException {
        assert Cin_Input != null : "fx:id=\"Cin_Input\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert Nom_Input != null : "fx:id=\"Nom_Input\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert Prenom_Input != null : "fx:id=\"Prenom_Input\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert Adresse_Input != null : "fx:id=\"Adresse_Input\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert Email_Input != null : "fx:id=\"Email_Input\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert DateNaissance_Input != null : "fx:id=\"DateNaissance_Input\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert Photo_Input != null : "fx:id=\"Photo_Input\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert button_Submit != null : "fx:id=\"button_Submit\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert Combomission != null : "fx:id=\"Combomission\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert btnClose != null : "fx:id=\"btnClose\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert Bt_Dashboard != null : "fx:id=\"Bt_Dashboard\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert Bt_Emp != null : "fx:id=\"Bt_Emp\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert Bt_Stock != null : "fx:id=\"Bt_Stock\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert Téléphoneinput != null : "fx:id=\"Téléphoneinput\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert alertNom != null : "fx:id=\"alertNom\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert alertCIN != null : "fx:id=\"alertCIN\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert alertPrenom != null : "fx:id=\"alertPrenom\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert alertAdresse != null : "fx:id=\"alertAdresse\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert alertDatenaissance != null : "fx:id=\"alertDatenaissance\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert alertEmail != null : "fx:id=\"alertEmail\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert alertRole != null : "fx:id=\"alertRole\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        assert alertTel != null : "fx:id=\"alertTel\" was not injected: check your FXML file 'AjouterEmp.fxml'.";
        
        List<String> list = new ArrayList<>();
        list.add("Livreur");
        list.add("Ouvrier");
        list.add("Techniciens");
        list.add("Ingénieur");
        ObservableList obList = FXCollections.observableList(list);
        Combomission.getItems().clear();
        Combomission.setItems(obList);
    }
}
