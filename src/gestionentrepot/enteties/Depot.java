package gestionentrepot.enteties;

import java.sql.Date;


public class Depot {
    private Integer id ;
    private int surface ;
    private String adr;
    private int id_pro;
    private int prix;
    private String Etat;
    private Date datefin;
    private Date datedebut;
    
    public Depot(int id, int surface, int id_pro,String adr) {
        this.id = id;
        this.surface = surface;
        this.id_pro = id_pro;
        this.adr = adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public String getAdr() {
        return adr;
    }
    
    

    public Depot() {
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public String getEtat() {
        return Etat;
    }

    public Depot(int id, String adr , String Etat, int prix, int surface) {
        this.id = id;
        this.surface = surface;
        this.prix = prix;
        this.Etat = Etat;
        this.adr=adr;
    }

    public int getPrix() {
        return prix;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }
    
    

    public void setPrix(Integer prix) {
        this.prix = prix;
    }
    
    
    
    
    

    public Integer getId() {
        return id;
    }

    public Integer getSurface() {
        return surface;
    }

    public int getId_pro() {
        return id_pro;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurface(Integer surface) {
        this.surface = surface;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
}
