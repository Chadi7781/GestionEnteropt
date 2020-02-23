
package gestionentrepot.service;

import gestionentrepot.enteties.USER;
import gestionentrepot.utils.BDConnector;
import gestionentrepot.utils.Utility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;


public class GestionEmployerService {

	static Connection conx = null;
	static ResultSet rs = null;
	static Statement stmt = null;
	static PreparedStatement req = null;

	public static USER getUnEmployeCIN(USER u) {
		USER user = new USER();
		try {
			conx = BDConnector.driverBD();
			stmt = conx.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + Utility.tableNameUser + " WHERE " + Utility.ROLE + " LIKE '"
					+ Utility.ROLE_EMPLOYER + "'  AND " + Utility.CIN + " like '%" + u.getCin() + "%'");

			while (rs.next()) {
				user.setAdresse(rs.getString(Utility.ADRESSE));
				user.setCin(rs.getString(Utility.CIN));
				user.setDatenaissance(rs.getDate(Utility.DATE_NAISSANCE));
				user.setEmail(rs.getString(Utility.EMAIL));
				user.setNom(rs.getString(Utility.NOM));
				user.setPrenom(rs.getString(Utility.PRENOM));
				user.setId(rs.getInt(Utility.ID));
				user.setRole(rs.getString(Utility.ROLE));
				user.setMission(rs.getString(Utility.MISSION));
				user.setNumtel(rs.getString(Utility.telephone));
			}
			return user;
		} catch (SQLException e) {
			System.out.println("Erreur :" + e.getMessage());
		}
		return null;
	}
        
        public static int getNbrOuvrier () throws SQLException{
            conx = BDConnector.driverBD();
            String sql ="SELECT count(*) from fos_user WHERE roles like '%EMPLOYE%' and mission ='Ouvrier'";
            req=conx.prepareStatement(sql);
            rs=req.executeQuery();
            if (rs.next()){
                return Integer.parseInt(rs.getString("count(*)"));
            }
            
            return 0;
        }
        
        public static int getNbrIngenieur () throws SQLException{
            conx = BDConnector.driverBD();
            String sql ="SELECT count(*) from fos_user WHERE roles like '%EMPLOYE%' and mission like 'Ing%nieur'";
            req=conx.prepareStatement(sql);
            rs=req.executeQuery();
            if (rs.next()){
                return Integer.parseInt(rs.getString("count(*)"));
            }
            return 0;
        }
        
        public static int getNbrTechnicien () throws SQLException{
            conx = BDConnector.driverBD();
            String sql ="SELECT count(*) from fos_user WHERE roles like '%EMPLOYE%' and mission like 'Techniciens'";
            req=conx.prepareStatement(sql);
            rs=req.executeQuery();
            if (rs.next()){

                return Integer.parseInt(rs.getString("count(*)"));
            }
            return 0;
        }
        
        public static int getNbrLivreur () throws SQLException{
            conx = BDConnector.driverBD();
            String sql ="SELECT count(*) from fos_user WHERE roles like '%EMPLOYE%' and mission like 'Livreur'";
            req=conx.prepareStatement(sql);
            rs=req.executeQuery();
            if (rs.next()){

                return Integer.parseInt(rs.getString("count(*)"));
            }
            return 0;
        }
        
                

	public static List<USER> AfficheToutEmploye() {
		try {
			conx = BDConnector.driverBD();
			stmt = conx.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + Utility.tableNameUser + " WHERE " + Utility.ROLE + " like '"
					+ Utility.ROLE_EMPLOYER + "'");

			List<USER> liste = new LinkedList<USER>();
			while (rs.next()) {
				USER employe = new USER();
				employe.setAdresse(rs.getString(Utility.ADRESSE));
				employe.setCin(rs.getString(Utility.CIN));
				employe.setDatenaissance(rs.getDate(Utility.DATE_NAISSANCE));
				employe.setEmail(rs.getString(Utility.EMAIL));
				employe.setNom(rs.getString(Utility.NOM));
				employe.setPrenom(rs.getString(Utility.PRENOM));
				employe.setId(rs.getInt(Utility.ID));
				employe.setMission(rs.getString(Utility.MISSION));
				employe.setNumtel(rs.getString(Utility.telephone));
				liste.add(employe);
			}
			return liste;
		} catch (SQLException e) {
			System.out.println("Erreur :" + e.getMessage());
			return null;
		}
	}

	/**
	 *
	 * @return
	 */
	public static boolean SupprimerToutEmploye() {
		try {
			conx = BDConnector.driverBD();
			stmt = conx.createStatement();
			stmt.execute("DELETE FROM " + Utility.tableNameUser + " WHERE " + Utility.ROLE + " like "
					+ Utility.ROLE_EMPLOYER + "");
			return true;
		} catch (SQLException e) {
			System.out.println("Erreur :" + e.getMessage());
			return false;
		}
	}

	/**
	 *
	 * @param employe
	 * @return
	 */
	public static int AjoutUnEmploye(USER employe) {
		try {
			conx = BDConnector.driverBD();
                        String requet = "INSERT INTO " + Utility.tableNameUser + " (" + Utility.listattribut
					+ ") VALUES (?,?,?,?,?,?,?,?,?,'modpass'";
                        if (employe.getMission()=="Livreur")
                            requet=requet+Utility.comma+"'Disponible'"+Utility.parenthaise;
                        else 
                            requet=requet+Utility.comma+"null"+Utility.parenthaise;
			req = conx.prepareStatement(requet);
			req.setString(1, employe.getNom());
			req.setString(2, employe.getPrenom());
			req.setString(3, employe.getEmail());
			req.setString(4, employe.getAdresse());
			req.setDate(5, employe.getDateNaissance());
			req.setString(6, employe.getCin());
			req.setString(7, employe.getRole());
			req.setString(8, employe.getMission());
			req.setString(9, employe.getNumtel());
			return req.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erreur :" + e.getMessage());
			return 0;
		}
	}

	public static int ModificationUnEmploye(USER employe) {
		try {
			conx = BDConnector.driverBD();
			req = conx.prepareStatement("UPDATE " + Utility.tableNameUser + " SET " + Utility.listattributupdate
					+ " WHERE " + Utility.ID + " =?");
			req.setString(1, employe.getNom());
			req.setString(2, employe.getPrenom());
			req.setString(3, employe.getEmail());
			req.setString(4, employe.getAdresse());
			req.setDate(5, employe.getDateNaissance());
			req.setString(6, employe.getCin());
			req.setString(7, employe.getRole());
			req.setString(8, employe.getMission());
			req.setString(9, employe.getNumtel());
			req.setInt(10, employe.getId());
			return req.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Erreur :" + e.getMessage());
			return 0;
		}
	}

	/**
	 *
	 * @param nom
	 * @return
	 */
	public static List getUnEmployeNom(USER user) {
		
		try {
			conx = BDConnector.driverBD();
			stmt = conx.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + Utility.tableNameUser + " WHERE " + Utility.ROLE + " like '"
					+ Utility.ROLE_EMPLOYER + "' AND " + Utility.NOM + " like '%" + user.getNom() + "%'");
                        List<USER> liste = new LinkedList<USER>();
			while (rs.next()) {
                            USER employe = new USER();
				employe.setAdresse(rs.getString(Utility.ADRESSE));
				employe.setCin(rs.getString(Utility.CIN));
				employe.setDatenaissance(rs.getDate(Utility.DATE_NAISSANCE));
				employe.setEmail(rs.getString(Utility.EMAIL));
				employe.setNom(rs.getString(Utility.NOM));
				employe.setPrenom(rs.getString(Utility.PRENOM));
				employe.setId(rs.getInt(Utility.ID));
				employe.setMission(rs.getString(Utility.MISSION));
				employe.setNumtel(rs.getString(Utility.telephone));
                                liste.add(employe);
			}
			return liste;
		} catch (SQLException e) {
			System.out.println("Erreur :" + e.getMessage());
		}
		return null;
	}

	public static boolean SupprimerUnEmploye(USER user) {
		try {
			conx = BDConnector.driverBD();
			stmt = conx.createStatement();
			stmt.execute("DELETE FROM " + Utility.tableNameUser + " WHERE " + Utility.ID + "='" + user.getId() + "'");
			return true;
		} catch (SQLException e) {
			System.out.println("Erreur :" + e.getMessage());
			return false;
		}
	}

}
