package hei.devweb.dao;

import hei.devweb.dao.impl.DataSourceProvider;
import hei.devweb.dao.impl.JoueurDaoImpl;
import hei.devweb.model.Joueur;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JoueurDaoTestCase {

	private JoueurDao joueurDao = new JoueurDaoImpl();

	@Before
	public void purgeBDD() throws Exception {
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		
		Statement stmt = connection.createStatement();
		stmt.executeUpdate("DELETE FROM `joueur`");
		stmt.executeUpdate("DELETE FROM `match`");
		stmt.executeUpdate("DELETE FROM `stade`");
		stmt.executeUpdate("DELETE FROM `equipe`");
		stmt.executeUpdate("INSERT INTO `equipe`(`nomPays`,`drapeau`,`groupe`) VALUES ('France','images/flag/France.png','E')");
		stmt.executeUpdate("INSERT INTO `equipe`(`nomPays`,`drapeau`,`groupe`) VALUES ('Suisse','images/flag/Switzerland.png','E')");
		stmt.executeUpdate("INSERT INTO `joueur`(`idJoueur`,`nom`,`prenom`,`numero`,`dateNaissance`,`nomPays`) VALUES (1,'Ribery','Franck',7,'1983-04-07','France')");
		stmt.executeUpdate("INSERT INTO `stade`(`nomStade`,`ville`,`capacite`) VALUES ('Arena Amazonia','Manaus',42374)");
		stmt.executeUpdate("INSERT INTO `match`(`idMatch`,`groupe`,`nomPays1`,`nomPays2`,`score1`,`score2`,`nomStade`,`affluence`,`dateMatch`,`completer`) VALUES (1,'E','France','Suisse',2,1,'Arena Amazonia','35000','2014-06-15','1')");
		stmt.close();
		connection.close();
	}
	
	@Test
	public void testlisterJoueurs() {
		List<Joueur> joueurs = joueurDao.listerJoueurs("France");
		Assert.assertEquals(1, joueurs.size());
		Assert.assertEquals(1, joueurs.get(0).getIdJoueur());
		Assert.assertEquals("Ribery", joueurs.get(0).getNom());
		Assert.assertEquals("Franck", joueurs.get(0).getPrenom());
		Assert.assertEquals(7, joueurs.get(0).getNumero());
		Assert.assertEquals("France", joueurs.get(0).getPays());
		
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.YEAR, 1983);
		cal.set(Calendar.MONTH, Calendar.APRIL);
		cal.set(Calendar.DATE, 7);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Assert.assertEquals(cal.getTime(), joueurs.get(0).getDateNaissance());
	}
	
	@Test
	public void testAjouterJoueur() throws Exception {
		
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.YEAR, 1987);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DATE, 19);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Joueur nouveauJoueur = new Joueur(2, "Benzema", "Karim", cal.getTime(), 10, "France");
		joueurDao.ajouterJoueur(nouveauJoueur);

		Connection connection = DataSourceProvider.getDataSource()
				.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet results = stmt.executeQuery("SELECT * FROM `joueur` WHERE `nom` = 'Benzema' AND `prenom` = 'Karim'");
		// On vérifie qu'il y a un retour
		Assert.assertTrue(results.next());
		// On vérifie les champs
		Assert.assertEquals("Benzema", results.getString("nom"));
		Assert.assertEquals("Karim", results.getString("prenom"));
		Assert.assertEquals(cal.getTime(), results.getDate("dateNaissance"));
		Assert.assertEquals(10, results.getInt("numero"));
		Assert.assertEquals("France", results.getString("nomPays"));
		// On vérifie qu'il n'y a qu'un résultat
		Assert.assertFalse(results.next());
	}
	
	@Test
	public void testSupprimerJoueur() throws Exception {
		
		joueurDao.supprimerJoueur(1);
		Connection connection = DataSourceProvider.getDataSource()
				.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet results = stmt.executeQuery("SELECT * FROM `joueur` WHERE `idJoueur`=1");
		// On vérifie qu'il n'y a pas de retour
		Assert.assertFalse(results.next());
	}
	
	@Test
	public void testjoueuridMoueur() throws Exception {
		Joueur joueur = joueurDao.joueuridMax();
		Assert.assertEquals(1, joueur.getIdJoueur());
		Assert.assertEquals("Ribery", joueur.getNom());
		Assert.assertEquals("Franck", joueur.getPrenom());
		Assert.assertEquals(7, joueur.getNumero());
		Assert.assertEquals("France", joueur.getPays());
		
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.YEAR, 1983);
		cal.set(Calendar.MONTH, Calendar.APRIL);
		cal.set(Calendar.DATE, 7);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Assert.assertEquals(cal.getTime(), joueur.getDateNaissance());
		
	}
}
