package hei.devweb.dao;

import hei.devweb.dao.impl.DataSourceProvider;
import hei.devweb.dao.impl.EquipeDaoImpl;
import hei.devweb.model.Equipe;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EquipeDaoTestCase {

	private EquipeDao equipeDao = new EquipeDaoImpl();

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
	public void testgetEquipe() {
		Equipe equipe = equipeDao.getEquipe("France");
		Assert.assertEquals("France", equipe.getNomPays());
		Assert.assertEquals("images/flag/France.png", equipe.getDrapeau());
		Assert.assertEquals("E", equipe.getGroupe());
	}
	
	@Test
	public void testListerEquipe() {
		List<Equipe> equipes = equipeDao.listerEquipes();
		Assert.assertEquals(2, equipes.size());
		Assert.assertEquals("France", equipes.get(0).getNomPays());
		Assert.assertEquals("images/flag/France.png", equipes.get(0).getDrapeau());
		Assert.assertEquals("E", equipes.get(0).getGroupe());
		Assert.assertEquals("Suisse", equipes.get(1).getNomPays());
		Assert.assertEquals("images/flag/Switzerland.png", equipes.get(1).getDrapeau());
		Assert.assertEquals("E", equipes.get(1).getGroupe());
	}
	
	@Test
	public void testListerEquipe1() {
		List<Equipe> equipes = equipeDao.listerEquipes("E");
		Assert.assertEquals(2, equipes.size());
		Assert.assertEquals("France", equipes.get(0).getNomPays());
		Assert.assertEquals("images/flag/France.png", equipes.get(0).getDrapeau());
		Assert.assertEquals("E", equipes.get(0).getGroupe());
		Assert.assertEquals("Suisse", equipes.get(1).getNomPays());
		Assert.assertEquals("images/flag/Switzerland.png", equipes.get(1).getDrapeau());
		Assert.assertEquals("E", equipes.get(1).getGroupe());
	}
	
	@Test
	public void testListerGroupe() {
		List<String> groupes = equipeDao.listerGroupes();
		Assert.assertEquals(1, groupes.size());
		Assert.assertEquals("E", groupes.get(0));
	}
		
}
