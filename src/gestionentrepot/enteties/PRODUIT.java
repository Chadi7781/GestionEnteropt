

package gestionentrepot.enteties;


public class PRODUIT {
    
    Integer ID_PRODUIT ; 
    String NOM_PRODUIT ; 
    String PHOTO_PRODUIT ; 
    Integer POIDS ; 
    Integer PRIX ; 
    Integer ETAT; 
    String DESCRIPTION ; 
    String CATEGORIE ; 
    Integer ID_DEPOT ;

    public PRODUIT(Integer ID_PRODUIT, String NOM_PRODUIT, String PHOTO_PRODUIT, Integer POIDS, Integer PRIX, Integer ETAT, String DESCRIPTION, String CATEGORIE, Integer ID_DEPOT) {
        this.ID_PRODUIT = ID_PRODUIT;
        this.NOM_PRODUIT = NOM_PRODUIT;
        this.PHOTO_PRODUIT = PHOTO_PRODUIT;
        this.POIDS = POIDS;
        this.PRIX = PRIX;
        this.ETAT = ETAT;
        this.DESCRIPTION = DESCRIPTION;
        this.CATEGORIE = CATEGORIE;
        this.ID_DEPOT = ID_DEPOT;
    }

    public PRODUIT() {    }

    public Integer getID_PRODUIT() {
        return ID_PRODUIT;
    }

    public String getNOM_PRODUIT() {
        return NOM_PRODUIT;
    }

    public String getPHOTO_PRODUIT() {
        return PHOTO_PRODUIT;
    }

    public Integer getPOIDS() {
        return POIDS;
    }

    public Integer getPRIX() {
        return PRIX;
    }

    public Integer getETAT() {
        return ETAT;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public String getCATEGORIE() {
        return CATEGORIE;
    }

    public Integer getID_DEPOT() {
        return ID_DEPOT;
    }

    public void setID_PRODUIT(Integer ID_PRODUIT) {
        this.ID_PRODUIT = ID_PRODUIT;
    }

    public void setNOM_PRODUIT(String NOM_PRODUIT) {
        this.NOM_PRODUIT = NOM_PRODUIT;
    }

    public void setPHOTO_PRODUIT(String PHOTO_PRODUIT) {
        this.PHOTO_PRODUIT = PHOTO_PRODUIT;
    }

    public void setPOIDS(Integer POIDS) {
        this.POIDS = POIDS;
    }

    public void setPRIX(Integer PRIX) {
        this.PRIX = PRIX;
    }

    public void setETAT(Integer ETAT) {
        this.ETAT = ETAT;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public void setCATEGORIE(String CATEGORIE) {
        this.CATEGORIE = CATEGORIE;
    }

    public void setID_DEPOT(Integer ID_DEPOT) {
        this.ID_DEPOT = ID_DEPOT;
    }
    
}
