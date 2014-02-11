package hei.devweb.dao;

import hei.devweb.model.Equipe;

import java.util.List;

public interface EquipeDao {

	public Equipe getEquipe(String nomPays);

	public List<Equipe> listerEquipes();
	
	public List<Equipe> listerEquipes(String groupe);
	
	public List<String> listerGroupes();
}
