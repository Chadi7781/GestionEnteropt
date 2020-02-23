/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pidev.util.ZoomManager;

/**
 *
 * @author PC
 */
public class PiDevAdmin extends Application {
    
      private double xOffset = 0;
        private double yOffset = 0;
        private BorderPane p;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("views/menu_admin.fxml"));
        
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
