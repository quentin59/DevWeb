package hei.devweb.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.dao.JoueurDao;
import hei.devweb.model.Joueur;

public class JoueurDaoImpl implements JoueurDao {

	public List<Joueur> listerJoueurs(String nomPays) {
		
		List<Joueur> listeJoueurs = new ArrayList<Joueur>();
	    try {
	        // Créer une nouvelle connexion à la BDD
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "SELECT * FROM `joueur` WHERE `nomPays`=? ORDER BY `numero` ASC");
	        stmt.setString(1,nomPays);
	        ResultSet results = stmt.executeQuery();
	        while (results.next()) {
	        	Joueur joueur = new Joueur(results.getInt("idJoueur"),results.getString("nom"), 
	                       results.getString("prenom"), results.getDate("dateNaissance"), results.getInt("numero"),results.getString("nomPays"));
	            listeJoueurs.add(joueur);
	        }
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return listeJoueurs;
	}

	public void ajouterJoueur(Joueur joueur) {
		
		// Créer une nouvelle connexion à la BDD
	    try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "INSERT INTO `joueur`(`nom`, `prenom`, `numero`, `dateNaissance`, `nomPays`) VALUES(?, ?, ?, ?, ?)");
	        stmt.setString(1, joueur.getNom());
	        stmt.setString(2, joueur.getPrenom());
	        stmt.setInt(3,joueur.getNumero());
	        stmt.setDate(4, new Date(joueur.getDateNaissance().getTime()));
	        stmt.setString(5,joueur.getPays());
	        stmt.executeUpdate();

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
	
public void supprimerJoueur(int idJoueur) {
		
		// Créer une nouvelle connexion à la BDD
	    try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "DELETE FROM `joueur` WHERE `idJoueur` = ?");
	        stmt.setInt(1,idJoueur);
	        stmt.executeUpdate();

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
	
	public Joueur joueuridMax() {
		
		Joueur joueur=null;
		try {
	        // Créer une nouvelle connexion à la BDD
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "SELECT * FROM `joueur` ORDER BY `idJoueur` DESC LIMIT 1");
	        ResultSet results = stmt.executeQuery();
	        results.next();
	        joueur = new Joueur(results.getInt("idJoueur"),results.getString("nom"), 
                    results.getString("prenom"), results.getDate("dateNaissance"), results.getInt("numero"),results.getString("nomPays"));
	        
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return joueur;
	}

}
