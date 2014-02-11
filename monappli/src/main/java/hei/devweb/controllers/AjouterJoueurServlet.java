package hei.devweb.controllers;

import hei.devweb.metier.Manager;
import hei.devweb.model.Joueur;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class AjouterJoueurServlet extends HttpServlet {

	private static final long serialVersionUID = -3146108564549864690L;
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	request.setCharacterEncoding("UTF-8");
	String nom = request.getParameter("nom");
	String prenom = request.getParameter("prenom");
	Integer numero = Integer.parseInt(request.getParameter("num"));
	String equipe = request.getParameter("equipe");
	Date dateNaissance = null;
	try {
		dateNaissance = dateFormat.parse(request.getParameter("dateNaissance"));
		
	} catch (ParseException e) {
		e.printStackTrace();
	}
	
	Joueur nouveauJoueur = new Joueur(null, nom, prenom, dateNaissance, numero, equipe);
	Manager.getInstance().ajouterJoueur(nouveauJoueur);
	// Récupération du dernier joueur entré, 
	// notamment pour récupérer l'idJoueur qui est complété lors de l'ajout à la bdd
	Joueur dernierJoueur = Manager.getInstance().joueuridMax();
	
	Gson gson = new Gson();
	String joueurJson = gson.toJson(dernierJoueur);
	response.setCharacterEncoding("UTF-8");
	response.setContentType("application/json");
	PrintWriter out = response.getWriter();
	out.append(joueurJson);
}
	
}
