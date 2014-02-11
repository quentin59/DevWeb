package hei.devweb.dao;

import hei.devweb.dao.impl.DataSourceProvider;
import hei.devweb.dao.impl.MatchDaoImpl;
import hei.devweb.model.Match;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MatchDaoTestCase {

	private MatchDao matchDao = new MatchDaoImpl();

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
		stmt.executeUpdate("INSERT INTO `equipe`(`nomPays`,`drapeau`,`groupe`) VALUES ('Brésil','images/flag/Brazil.png','A')");
		stmt.executeUpdate("INSERT INTO `equipe`(`nomPays`,`drapeau`,`groupe`) VALUES ('Mexique','images/flag/Mexico.png','A')");
		stmt.executeUpdate("INSERT INTO `joueur`(`idJoueur`,`nom`,`prenom`,`numero`,`dateNaissance`,`nomPays`) VALUES (1,'Ribery','Franck',7,'1983-04-07','France')");
		stmt.executeUpdate("INSERT INTO `stade`(`nomStade`,`ville`,`capacite`) VALUES ('Arena Amazonia','Manaus',42374)");
		stmt.executeUpdate("INSERT INTO `match`(`idMatch`,`groupe`,`nomPays1`,`nomPays2`,`score1`,`score2`,`nomStade`,`affluence`,`dateMatch`,`completer`) VALUES (1,'E','France','Suisse',null,null,null,null,null,'0')");
		stmt.executeUpdate("INSERT INTO `match`(`idMatch`,`groupe`,`nomPays1`,`nomPays2`,`score1`,`score2`,`nomStade`,`affluence`,`dateMatch`,`completer`) VALUES (2,'A','Brésil','Mexique',3,2,'Arena Amazonia','32000','2014-06-12','1')");

		stmt.close();
		connection.close();
	}
	
	@Test
	public void testCompleterMatch() throws Exception {
		
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, Calendar.JUNE);
		cal.set(Calendar.DATE, 10);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		Match match = new Match(1, "France", "Suisse", 2, 1, "Arena Amazonia", 35000, cal.getTime(), true);
		matchDao.completerMatch(match);

		Connection connection = DataSourceProvider.getDataSource()
				.getConnection();
		Statement stmt = connection.createStatement();
		ResultSet results = stmt.executeQuery("SELECT * FROM `match` WHERE `idMatch`=1");
		// On vérifie qu'il y a un retour
		Assert.assertTrue(results.next());
		// On vérifie les champs
		Assert.assertEquals(1, results.getInt("idMatch"));
		Assert.assertEquals("E", results.getString("groupe"));
		Assert.assertEquals("France", results.getString("nomPays1"));
		Assert.assertEquals("Suisse", results.getString("nomPays2"));
		Assert.assertEquals(2, results.getInt("score1"));
		Assert.assertEquals(1, results.getInt("score2"));
		Assert.assertEquals("Arena Amazonia", results.getString("nomStade"));
		Assert.assertEquals(35000, results.getInt("affluence"));
		Assert.assertEquals(cal.getTime(), results.getDate("dateMatch"));
		Assert.assertTrue(results.getBoolean("completer"));
		// On vérifie qu'il n'y a qu'un résultat
		Assert.assertFalse(results.next());
	}
	
	@Test
	public void testgetMatch() {
		Match match = matchDao.getMatch(2);
		Assert.assertEquals(2, match.getIdMatch());
		Assert.assertEquals("Brésil", match.getEquipe1());
		Assert.assertEquals("Mexique", match.getEquipe2());
		Assert.assertEquals(3, match.getScoreEquipe1());
		Assert.assertEquals(2, match.getScoreEquipe2());
		Assert.assertEquals("Arena Amazonia", match.getStade());
		Assert.assertEquals(32000, match.getAffluence());
		Assert.assertTrue(match.isCompleter());

		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, Calendar.JUNE);
		cal.set(Calendar.DATE, 12);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Assert.assertEquals(cal.getTime(), match.getDateMatch());
	}
	
	@Test
	public void testListerMatchs() {
		List<Match> matchs = matchDao.listerMatchs("A");
		Assert.assertEquals(1, matchs.size());
		Assert.assertEquals(2, matchs.get(0).getIdMatch());
		Assert.assertEquals("Brésil", matchs.get(0).getEquipe1());
		Assert.assertEquals("Mexique", matchs.get(0).getEquipe2());
		Assert.assertEquals(3, matchs.get(0).getScoreEquipe1());
		Assert.assertEquals(2, matchs.get(0).getScoreEquipe2());
		Assert.assertEquals("Arena Amazonia", matchs.get(0).getStade());
		Assert.assertEquals(32000, matchs.get(0).getAffluence());
		Assert.assertTrue(matchs.get(0).isCompleter());

		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, Calendar.JUNE);
		cal.set(Calendar.DATE, 12);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Assert.assertEquals(cal.getTime(), matchs.get(0).getDateMatch());
	}
	
	@Test
	public void testGenererMatchs() {
		
	}
}
