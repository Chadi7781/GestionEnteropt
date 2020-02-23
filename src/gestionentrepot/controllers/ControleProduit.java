
package gestionentrepot.controllers;

import gestionentrepot.enteties.PRODUIT;
import gestionentrepot.service.GestionProduitService;
import java.util.List;


public class ControleProduit {
    	public static boolean ControleNOM(PRODUIT u) {
		String str = (u.getNOM_PRODUIT()).toLowerCase();
                if (str.length() == 0)
                    return false;
		return true;
	}
	List<PRODUIT> AfficheToutProduit() {
		return GestionProduitService.AfficheToutProduit();
	}
        
        List<PRODUIT> AfficheToutProduitParLIB(PRODUIT p) {
		return GestionProduitService.AfficheToutProduitParLIB(p);
	}
                

	public static void main(String[] a) {
		ControleProduit controleProduit = new ControleProduit();
		List<PRODUIT> list = controleProduit.AfficheToutProduit();
		for (int i = 0; i < list.size(); i++) {
			System.out.println((list.get(i)).getDESCRIPTION());
		}
	}
        


}
