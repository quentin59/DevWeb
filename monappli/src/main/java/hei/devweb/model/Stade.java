package hei.devweb.model;

public class Stade {
	
	private String nom;
	private String ville;
	private int capacite;
	
	public Stade(String n, String v, int c) {
		this.nom=n;
		this.ville=v;
		this.capacite=c;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	
}