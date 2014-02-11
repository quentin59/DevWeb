package hei.devweb.dao;

import java.util.List;

import hei.devweb.model.Match;

public interface MatchDao {

	public void completerMatch(Match match);

	public Match getMatch(int idMatch);
	
	public List<Match> listerMatchs(String groupe);
	
	public boolean isGenerer(String groupe);
	
	public void genererMatchs(String groupe);
}
