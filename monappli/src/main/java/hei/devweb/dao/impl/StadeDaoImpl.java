package hei.devweb.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.dao.StadeDao;
import hei.devweb.model.Stade;

public class StadeDaoImpl implements StadeDao {

	public List<Stade> listerStades() {

		List<Stade> listeStades = new ArrayList<Stade>();
	    try {
	        // Créer une nouvelle connexion à la BDD
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        Statement stmt = connection.createStatement();
	        ResultSet results = stmt.executeQuery("SELECT * FROM `stade` ORDER BY `capacite` ASC");
	        while (results.next()) {
	        	Stade stade = new Stade(results.getString("nomStade"), 
	                       results.getString("ville"), results.getInt("capacite"));
	            listeStades.add(stade);
	        }
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return listeStades;
	}
	
}
