package hei.devweb.metier;

import hei.devweb.dao.EquipeDao;
import hei.devweb.dao.JoueurDao;
import hei.devweb.dao.MatchDao;
import hei.devweb.dao.StadeDao;
import hei.devweb.dao.impl.EquipeDaoImpl;
import hei.devweb.dao.impl.MatchDaoImpl;
import hei.devweb.dao.impl.StadeDaoImpl;
import hei.devweb.dao.impl.JoueurDaoImpl;
import hei.devweb.model.Equipe;
import hei.devweb.model.Joueur;
import hei.devweb.model.Match;
import hei.devweb.model.Stade;

import java.util.List;

public class Manager {

	private static Manager instance;
	
	private EquipeDao equipeDao = new EquipeDaoImpl();
	private JoueurDao joueurDao = new JoueurDaoImpl();
	private MatchDao matchDao = new MatchDaoImpl();
	private StadeDao stadeDao = new StadeDaoImpl();
		
	public static Manager getInstance() {
		if(instance == null) {
			instance = new Manager();
		}
		return instance;
	}
	
	public List<Equipe> listerEquipes() {
		return equipeDao.listerEquipes();
	}
	
	public List<Equipe> listerEquipes(String groupe) {
		
		return equipeDao.listerEquipes(groupe);
	}
	
	public Equipe getEquipe(String nomPays) {
		return equipeDao.getEquipe(nomPays);
	}
	
	public List<String> listerGroupes() {
		return equipeDao.listerGroupes();
	}
	
	public List<Joueur> listerJoueurs(String nomPays) {
		return joueurDao.listerJoueurs(nomPays);
	}

	public void ajouterJoueur(Joueur nouveauJoueur) {
		joueurDao.ajouterJoueur(nouveauJoueur);
	}
	
	public void supprimerJoueur(int idJoueur) {
		joueurDao.supprimerJoueur(idJoueur);
	}
	
	public Joueur joueuridMax() {
		return joueurDao.joueuridMax();
	}
	
	public void completerMatch(Match match){
		matchDao.completerMatch(match);
	}

	public Match getMatch(int idMatch) {
		return matchDao.getMatch(idMatch);
	}
	
	public boolean isGenerer(String groupe) {
		return matchDao.isGenerer(groupe);
	}
	
	public List<Match> listerMatchs(String groupe) {
		return matchDao.listerMatchs(groupe);
	}
	
	public void genererMatchs(String groupe) {
		matchDao.genererMatchs(groupe);
	}
	
	public List<Stade> listerStades() {
		return stadeDao.listerStades();
	}
	
}
