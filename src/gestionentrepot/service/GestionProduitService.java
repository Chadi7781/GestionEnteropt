
package gestionentrepot.service;

import gestionentrepot.enteties.PRODUIT;
import static gestionentrepot.service.GestionEmployerService.conx;
import static gestionentrepot.service.GestionEmployerService.rs;
import static gestionentrepot.service.GestionEmployerService.stmt;
import gestionentrepot.utils.BDConnector;
import gestionentrepot.utils.Utility;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class GestionProduitService {

	public static List<PRODUIT> AfficheToutProduit() {
		try {
			conx = BDConnector.driverBD();
			stmt = conx.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + Utility.tableNameProduit + "");
			List<PRODUIT> liste = new LinkedList<PRODUIT>();
			while (rs.next()) {
                            PRODUIT produit = new PRODUIT();
				produit.setCATEGORIE(rs.getString(Utility.CATEGORIE));
				produit.setDESCRIPTION(rs.getString(Utility.DESCRIPTION));
				produit.setETAT(rs.getInt(Utility.ETAT));
				produit.setID_DEPOT(rs.getInt(Utility.ID_DEPOT));
				produit.setNOM_PRODUIT(rs.getString(Utility.nom_produit));
				produit.setPHOTO_PRODUIT(rs.getString(Utility.PHOTO_PRODUIT));
				produit.setPOIDS(rs.getInt(Utility.POIDS));
				produit.setPRIX(rs.getInt(Utility.PRIX));
				produit.setID_PRODUIT(rs.getInt(Utility.ID_PRODUIT));
				liste.add(produit);
			}
			return liste;
		} catch (SQLException e) {
			System.out.println("Erreur :" + e.getMessage());
			return null;
		}
	}

        	public static List<PRODUIT> AfficheToutProduitParLIB(PRODUIT p) {
		try {
			conx = BDConnector.driverBD();
			stmt = conx.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + Utility.tableNameProduit +" WHERE "+ Utility.nom_produit + " like '%" + p.getNOM_PRODUIT() + "%'");
			List<PRODUIT> liste = new LinkedList<PRODUIT>();
			while (rs.next()) {
                            PRODUIT produit = new PRODUIT();
				produit.setCATEGORIE(rs.getString(Utility.CATEGORIE));
				produit.setDESCRIPTION(rs.getString(Utility.DESCRIPTION));
				produit.setETAT(rs.getInt(Utility.ETAT));
				produit.setID_DEPOT(rs.getInt(Utility.ID_DEPOT));
				produit.setNOM_PRODUIT(rs.getString(Utility.nom_produit));
				produit.setPHOTO_PRODUIT(rs.getString(Utility.PHOTO_PRODUIT));
				produit.setPOIDS(rs.getInt(Utility.POIDS));
				produit.setPRIX(rs.getInt(Utility.PRIX));
				produit.setID_PRODUIT(rs.getInt(Utility.ID_PRODUIT));
				liste.add(produit);
			}
			return liste;
		} catch (SQLException e) {
			System.out.println("Erreur :" + e.getMessage());
			return null;
		}
	}

}
