package hei.devweb.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.metier.Manager;
import hei.devweb.model.Equipe;
import hei.devweb.model.Joueur;
import hei.devweb.model.Match;
import hei.devweb.model.Stade;
import hei.devweb.dao.MatchDao;

public class MatchDaoImpl implements MatchDao {

	public void completerMatch(Match match) {
		
		// Créer une nouvelle connexion à la BDD
	    try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "UPDATE `match` SET `score1`=?, `score2`=?, `nomStade`=?, `affluence`=?, `dateMatch`=?, `completer`=? WHERE `idMatch`=?");
	        stmt.setInt(1, match.getScoreEquipe1());
	        stmt.setInt(2, match.getScoreEquipe2());
	        stmt.setString(3,match.getStade());
	        stmt.setInt(4,match.getAffluence());
	        stmt.setDate(5, new Date(match.getDateMatch().getTime()));
	        stmt.setBoolean(6, match.isCompleter());
	        stmt.setInt(7, match.getIdMatch());
	       
	        stmt.executeUpdate();

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public Match getMatch(int idMatch) {

		Match match=null;
		// Créer une nouvelle connexion à la BDD
	    try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "SELECT * FROM `match` WHERE `idMatch`=?");
	        stmt.setInt(1,idMatch);
	        ResultSet results = stmt.executeQuery();
	        results.next();
	        match = new Match(results.getInt("idMatch"),results.getString("nomPays1"), 
                    results.getString("nomPays2"), results.getInt("score1"), results.getInt("score2"), results.getString("nomStade"), results.getInt("affluence"), results.getDate("dateMatch"),results.getBoolean("completer"));
	            
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return match;
	}
	
	public List<Match> listerMatchs(String groupe) {

		List<Match> listeMatchs = new ArrayList<Match>();
	    try {
	        // Créer une nouvelle connexion à la BDD
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	        		"SELECT * FROM `match` WHERE `groupe`=?");
	        stmt.setString(1, groupe);
	        ResultSet results = stmt.executeQuery();
	        while (results.next()) {
	        	Match match = new Match(results.getInt("idMatch"),results.getString("nomPays1"), 
	                    results.getString("nomPays2"), results.getInt("score1"), results.getInt("score2"), results.getString("nomStade"), results.getInt("affluence"), results.getDate("dateMatch"),results.getBoolean("completer"));
	            listeMatchs.add(match);
	        }
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return listeMatchs;
	}
	
	public boolean isGenerer(String groupe) {
		
		if (listerMatchs(groupe).isEmpty())
		{
			return (false);
		}
		else
		{
			return(true);
		}
	}
	
	public void genererMatchs(String groupe) {
		
		List<Equipe> listeEquipe=Manager.getInstance().listerEquipes(groupe);
		int i,j;
		// Créer une nouvelle connexion à la BDD
	    try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();
	        
	        // Algorithme pour que toutes les équipes d'un groupe se rencontrent
		for (i=listeEquipe.size()-1;i>=0;i--)
		{
			for (j=0;j<i;j++)
			{
				Equipe equipe1=listeEquipe.get(i);
				Equipe equipe2=listeEquipe.get(j);

			    // Utiliser la connexion
			    PreparedStatement stmt = connection.prepareStatement(
			              "INSERT INTO `match`(`groupe`, `nomPays1`, `nomPays2`,`completer`) VALUES(?, ?, ?, ?)");
			    stmt.setString(1, groupe);
			    stmt.setString(2, equipe1.getNomPays());
			    stmt.setString(3, equipe2.getNomPays());
			    stmt.setBoolean(4, false);
			    stmt.executeUpdate();
			}
		}
		
		// Fermer la connexion
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
		
	}

}
