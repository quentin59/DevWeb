package hei.devweb.dao;

import java.util.List;

import hei.devweb.model.Joueur;

public interface JoueurDao {

	public List<Joueur> listerJoueurs(String nomPays);

	public void ajouterJoueur(Joueur nouveauJoueur);
	
	public void supprimerJoueur(int idJoueur);
	
	public Joueur joueuridMax();
}
