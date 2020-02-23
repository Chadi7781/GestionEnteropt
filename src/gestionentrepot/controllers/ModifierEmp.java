
package gestionentrepot.controllers;

import gestionentrepot.enteties.USER;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ModifierEmp {
    @FXML
    private TextField telephone_input;
        
    @FXML
    private Button button_Submit;

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
    private Button button_Exit;
    
    @FXML
    private Text alertTel;
    
    @FXML
    private Button Bt_Emp;

    @FXML
    private Button Bt_Dashboard1;

    @FXML
    private Button Bt_Stock1;

    @FXML
    private Button Bt_Emp1;

    @FXML
    private Text alertCIN;

    @FXML
    private Text alertAdresse;

    @FXML
    private Text alertNom;

    @FXML
    private Text alertEmail;

    @FXML
    private Text alertPrenom;

    @FXML
    private Text alertMIssion;

    @FXML
    private Text alertDateNaissance;
    
        @FXML
    private ComboBox<String> ComboxMission;

	@FXML
	void handleButtonExitAction(ActionEvent event) {

	}

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
        if (ComboxMission.getSelectionModel().getSelectedItem() != null){
        mission = ComboxMission.getSelectionModel().getSelectedItem().toString();
        }
        String numtel = telephone_input.getText().toString().toLowerCase();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);          
        alert.setTitle("Gestion entropôt");
        alert.setHeaderText("Mofication de l'employé");
        Boolean retourstr= true;
        USER u = new USER(nom, prenom, email, cin, adresse, datenaissance, "EMPLOYE", mission,numtel);
        if (!control.ControleCIN(u)){
            alertCIN.setText("CIN non valable. ");
            retourstr=false;
        }
        if (!control.ControleROLE(u)){
            alertMIssion.setText("Mission non valable. ");
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
            alertDateNaissance.setText("Date naissance non valable. ");
            retourstr=false;
        }
        
        if (!control.ControleTELNUMBER(u)){
            alertTel.setText("Numero de telephone non valable. ");
            retourstr=false;
        }
        if (retourstr==true) {
        String ajoutEmployer = control.ModificationUnEmploye(u);
        if (ajoutEmployer.equals("")){
            alert.setContentText("Employer modifié avec succès !");
            alert.showAndWait();
        }
        else {
            alert.setContentText(ajoutEmployer);
            alert.showAndWait();
        }
        }
        }
         @FXML
    void gotoDashboard(ActionEvent event) throws IOException {
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
    void handleMouseEvent (ActionEvent event){
        
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
    
    public void initdata (USER u){
        Cin_Input.setText(u.getCin());
        Adresse_Input.setText(u.getAdresse());
        DateNaissance_Input.setValue(u.getDateNaissance().toLocalDate());
        Email_Input.setText(u.getEmail());
        Nom_Input.setText(u.getNom());
        Prenom_Input.setText(u.getPrenom()); 
        ComboxMission.setValue(u.getMission());
        telephone_input.setText(u.getNumtel());
        
    }

	@FXML
	void initialize() {
  assert button_Submit != null : "fx:id=\"button_Submit\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert Cin_Input != null : "fx:id=\"Cin_Input\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert Nom_Input != null : "fx:id=\"Nom_Input\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert Prenom_Input != null : "fx:id=\"Prenom_Input\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert Adresse_Input != null : "fx:id=\"Adresse_Input\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert Email_Input != null : "fx:id=\"Email_Input\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert DateNaissance_Input != null : "fx:id=\"DateNaissance_Input\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert Photo_Input != null : "fx:id=\"Photo_Input\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert button_Exit != null : "fx:id=\"button_Exit\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert Bt_Emp != null : "fx:id=\"Bt_Emp\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert Bt_Dashboard1 != null : "fx:id=\"Bt_Dashboard1\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert Bt_Stock1 != null : "fx:id=\"Bt_Stock1\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert Bt_Emp1 != null : "fx:id=\"Bt_Emp1\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert alertCIN != null : "fx:id=\"alertCIN\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert alertAdresse != null : "fx:id=\"alertAdresse\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert alertNom != null : "fx:id=\"alertNom\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert alertEmail != null : "fx:id=\"alertEmail\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert alertPrenom != null : "fx:id=\"alertPrenom\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert alertMIssion != null : "fx:id=\"alertMIssion\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        assert alertDateNaissance != null : "fx:id=\"alertDateNaissance\" was not injected: check your FXML file 'ModifierEmp.fxml'.";
        List<String> list = new ArrayList<>();
        list.add("Livreur");
        list.add("Ouvrier");
        list.add("Techniciens");
        list.add("Ingénieur");
        ObservableList obList = FXCollections.observableList(list);
        ComboxMission.getItems().clear();
        ComboxMission.setItems(obList);
	}
}
