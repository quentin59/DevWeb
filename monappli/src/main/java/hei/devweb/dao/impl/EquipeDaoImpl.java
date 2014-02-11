package hei.devweb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.dao.EquipeDao;
import hei.devweb.model.Equipe;

public class EquipeDaoImpl implements EquipeDao{

	public List<Equipe> listerEquipes() {
		
		List<Equipe> listeEquipes = new ArrayList<Equipe>();
	    try {
	        // Créer une nouvelle connexion à la BDD
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        Statement stmt = connection.createStatement();
	        ResultSet results = stmt.executeQuery("SELECT * FROM `equipe` ORDER BY `nomPays` ASC");
	        while (results.next()) {
	        	Equipe equipe = new Equipe(results.getString("nomPays"), 
	                       results.getString("drapeau"), results.getString("groupe"));
	            listeEquipes.add(equipe);
	        }
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return listeEquipes;
	}

	public Equipe getEquipe(String nomPays) {

		Equipe equipe=null;
		// Créer une nouvelle connexion à la BDD
	    try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "SELECT * FROM `equipe` WHERE `nomPays`=?");
	        stmt.setString(1,nomPays);
	        ResultSet results = stmt.executeQuery();
	        results.next();
	        equipe = new Equipe(results.getString("nomPays"), 
                    results.getString("drapeau"), results.getString("groupe"));
	            
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return equipe;
	}

	public List<Equipe> listerEquipes(String groupe) {

		List<Equipe> listeEquipes = new ArrayList<Equipe>();
			
	    try {
	        // Créer une nouvelle connexion à la BDD
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "SELECT * FROM `equipe` WHERE `groupe`=?");
	        stmt.setString(1,groupe);
	        ResultSet results = stmt.executeQuery();
	        while (results.next()) {
	        	Equipe equipe = new Equipe(results.getString("nomPays"), 
	                       results.getString("drapeau"), results.getString("groupe"));
	            listeEquipes.add(equipe);
	        }
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return listeEquipes;
	}
	
	public List<String> listerGroupes() {
		
		List<String> listeGroupes = new ArrayList<String>();
	    try {
	        // Créer une nouvelle connexion à la BDD
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        Statement stmt = connection.createStatement();
	        ResultSet results = stmt.executeQuery("SELECT DISTINCT groupe FROM `equipe` ORDER BY groupe ASC");
	        while (results.next()) {
	            listeGroupes.add(results.getString("groupe"));
	        }
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return listeGroupes;
	}

}
