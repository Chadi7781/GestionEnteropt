/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionentrepot.service;

import pidev.services.*;
import java.sql.ResultSet;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import pidev.entity.Reclamation;
import pidev.entity.Utilisateur;

/**
 *
 * @author PC
 */
public interface IReclamationService {
    public void ajouterReclamation(Reclamation p);  
    public void modifierReclamation(Reclamation p);
    public ObservableList<Reclamation> getAllReclamation();
    
    public void  traiterReclamation(Reclamation p);
    
    public int getNbrReclamation();
    
   
 
    
    public BarChart loadChart();
    
    
}
