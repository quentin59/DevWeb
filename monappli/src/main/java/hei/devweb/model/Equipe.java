package hei.devweb.model;

public class Equipe {

	private String nomPays;
	private String drapeau;
	private String groupe;
	
	public Equipe(String nom, String dra, String gr) {
		this.nomPays = nom;
		this.drapeau = dra;
		this.groupe = gr;
		}

	
	public String getNomPays() {
		return nomPays;
	}
	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}
	
	public String getDrapeau() {
		return drapeau;
	}
	public void setDrapeau(String drapeau) {
		this.drapeau = drapeau;
	}
	
	public String getGroupe() {
		return groupe;
	}
	public void setGroupe(String groupe) {
		this.groupe = groupe;
	}
		
}
