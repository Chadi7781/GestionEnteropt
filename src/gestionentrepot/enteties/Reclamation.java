/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionentrepot.enteties;

import pidev.entity.*;
import com.jfoenix.controls.JFXButton;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/** 
 *.* @author PC
 */


public class Reclamation {
    String objet;
    String description;
    int etat;
    Date date;
    int id_rec;
    int id;
    Blob image;
    String email;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId_rec() {
        return id_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public int getId_user() {
        return id;
    }

    public void setId_user(int id) {
        this.id = id;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public int getId() {
        return id_rec;
    }

    public void setId(int id_rec) {
        this.id_rec = id_rec;
    }

    public Reclamation(String objet, String description, Blob image) {
        this.objet = objet;
        this.description = description;
        this.image = image;
    }
        public Reclamation(String objet, String description,int id_rec, int etat,int id,String email) {
        this.objet = objet;
        this.description = description;
        this.etat=etat;
        this.id_rec=id_rec;
        this.id=id;
        this.email = email;
    }

    public Reclamation(String objet, String description, int etat, Date date, int id_rec) {
        this.objet = objet;
        this.description = description;
        this.etat = etat;
        this.date = date;
        this.id_rec = id_rec;
    }

    public Reclamation(int id_rec,String objet, String description,int etat,int id) {
        this.objet = objet;
        this.description = description;
        this.etat = etat;
        this.id_rec = id_rec;
        this.id=id;
    }
  

    public Reclamation(String objet, String description) {
        this.objet = objet;
        this.description = description;
    }


    public Reclamation(String objet, String description, Date date) {
        this.objet = objet;
        this.description = description;
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Reclamation() {
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
    

    @Override
    public String toString() {
        return "Reclamation{" + "objet=" + objet + ", description=" + description + ", etat=" + etat + ", date=" + date + ", id_rec=" + id_rec + ", id=" + id + ", image=" + image + '}';
    }

   
}