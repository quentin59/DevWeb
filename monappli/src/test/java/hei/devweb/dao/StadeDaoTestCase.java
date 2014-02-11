package hei.devweb.dao;

import hei.devweb.dao.impl.DataSourceProvider;
import hei.devweb.dao.impl.StadeDaoImpl;
import hei.devweb.model.Stade;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StadeDaoTestCase {

	private StadeDao stadeDao = new StadeDaoImpl();

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
	public void testListerStades() throws Exception {
		List<Stade> stades = stadeDao.listerStades();
		Assert.assertEquals(1, stades.size());
		Assert.assertEquals("Arena Amazonia", stades.get(0).getNom());
		Assert.assertEquals("Manaus", stades.get(0).getVille());
		Assert.assertEquals(42374, stades.get(0).getCapacite());
	}
}
