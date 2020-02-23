
package gestionentrepot.utils;

import java.sql.*;

public class BDConnector {
	static Connection conx = null;
	static ResultSet rs = null;
	static Statement stmt = null;

	public static void main(String[] args) {
		conx = driverBD();
	}

	public static Connection driverBD() {
		try {

			Class.forName("com.mysql.jdbc.Driver");   //protocole appel le packetge du driver du jdbc mysql
			String url = "jdbc:mysql://localhost:3306/gestion_entrepot";  //nom base.port.jdbc driver
			Connection conx = DriverManager.getConnection(url, "root", "");
			return conx;
		} catch (Exception e) {
			System.out.println("Erreur lors du chargement du pilote :" + e.getMessage());
			return null;

		}
	}
}