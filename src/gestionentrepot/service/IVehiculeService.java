/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionentrepot.service;

import gestionentrepot.enteties.Vehicule;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author PC
 */
public interface IVehiculeService {
    public void ajouterVehicule(Vehicule v);  
    public void modifierVehicule(Vehicule v);
    public void supprimerVehicule(Vehicule v);
    public ObservableList<Vehicule> getVehicule();
    public String getVehiculeById();
}
