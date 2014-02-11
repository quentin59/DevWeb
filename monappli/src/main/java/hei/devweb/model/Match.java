package hei.devweb.model;

import java.util.Date;

public class Match {

	private int idMatch;
	private String equipe1;
	private String equipe2;
	private int scoreEquipe1;
	private int scoreEquipe2;
	private String stade;
	private int affluence;
	private Date dateMatch;
	private boolean completer=false;
	
	public Match(int id, String e1, String e2, int s1, int s2, String st, int af, Date date, boolean comp) {
		this.idMatch=id;
		this.equipe1=e1;
		this.equipe2=e2;
		this.scoreEquipe1=s1;
		this.scoreEquipe2=s2;
		this.stade=st;
		this.affluence=af;
		this.dateMatch=date;
		this.completer=comp;
	}

	public int getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(int idMatch) {
		this.idMatch = idMatch;
	}
	
	public String getEquipe1() {
		return equipe1;
	}

	public void setEquipe1(String equipe1) {
		this.equipe1 = equipe1;
	}

	public String getEquipe2() {
		return equipe2;
	}

	public void setEquipe2(String equipe2) {
		this.equipe2 = equipe2;
	}

	public int getScoreEquipe1() {
		return scoreEquipe1;
	}

	public void setScoreEquipe1(int scoreEquipe1) {
		this.scoreEquipe1 = scoreEquipe1;
	}

	public int getScoreEquipe2() {
		return scoreEquipe2;
	}

	public void setScoreEquipe2(int scoreEquipe2) {
		this.scoreEquipe2 = scoreEquipe2;
	}

	public String getStade() {
		return stade;
	}

	public void setStade(String stade) {
		this.stade = stade;
	}

	public int getAffluence() {
		return affluence;
	}

	public void setAffluence(int affluence) {
		this.affluence = affluence;
	}

	public Date getDateMatch() {
		return dateMatch;
	}

	public void setDateMatch(Date dateMatch) {
		this.dateMatch = dateMatch;
	}

	public boolean isCompleter() {
		return completer;
	}

	public void setCompleter(boolean completer) {
		this.completer = completer;
	}
}
