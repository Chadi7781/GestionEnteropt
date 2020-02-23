/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import java.sql.Connection;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.management.Notification;
import org.controlsfx.control.Notifications;

/**
 *
 * @author PC
 */
public class PiDev extends Application {
    
      private double xOffset = 0;
        private double yOffset = 0;
        private BorderPane p;
    
    @Override
    public void start(Stage stage) throws Exception {
         
        
        Parent root = FXMLLoader.load(getClass().getResource("views/ajout_reclamation.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        
        root.setOnMousePressed(((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getScreenY();
        }));
        
        root.setOnMouseDragged((MouseEvent event)->{
            stage.setX(event.getSceneX() - xOffset);
            stage.setY(event.getSceneY() - yOffset);

        });
        
                stage.setScene(scene);
                new animatefx.animation.ZoomIn(root).play();

        stage.show();
        

        

    }
    
 
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                launch(args);

        
    }
    
}
