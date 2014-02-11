package hei.devweb.model;

import java.util.Date;

public class Joueur {

	private Integer idJoueur;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private int numero;
	private String pays;
	
	public Joueur(Integer id, String nom, String p, Date d, int num, String pa) {
		this.idJoueur=id;
		this.nom=nom;
		this.prenom=p;
		this.dateNaissance=d;
		this.numero=num;
		this.pays=pa;
	}
	
	public int getIdJoueur() {
		return idJoueur;
	}
	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	
}
