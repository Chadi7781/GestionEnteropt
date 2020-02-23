
package gestionentrepot.enteties;

import java.sql.Date;

import java.util.Objects;

public class USER {

        Integer id;
        String nom;
        String prenom;
        String email;
        String cin;
        String adresse;
        Date datenaissance;
        String role;
        String mission;
        String numtel;
                

    public USER(String nom, String prenom, String email, String cin, String adresse ,Date datenaissance, String role, String mission, String numtel) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.cin = cin;
        this.adresse = adresse;
        this.datenaissance = datenaissance;
        this.role = role;
        this.mission = mission;
        this.numtel = numtel;
        
    }
    
        public USER(Integer id,String nom, String prenom, String email, String cin, String adresse ,Date datenaissance, String role, String mission, String numtel) {
            this.id = id;
            this.nom = nom;
            this.prenom = prenom;
            this.email = email;
            this.cin = cin;
            this.adresse = adresse;
            this.datenaissance = datenaissance;
            this.role = role;
            this.mission = mission;
            this.numtel = numtel;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getRole() {
        return role;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMission() {
        return mission;
    }

    public void setMission(String mission) {
        this.mission = mission;
    }

    public Integer getId() {
        return id;
    }

    public Date getDateNaissance() {
        return datenaissance;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getCin() {
        return cin;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setId(int Id) {
        this.id = Id;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
   
    public USER() {}
       
           @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        final USER other = (USER) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }   	
}
        
    