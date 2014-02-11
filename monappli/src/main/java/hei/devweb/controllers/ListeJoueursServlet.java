package hei.devweb.controllers;

import hei.devweb.metier.Manager;
import hei.devweb.model.Equipe;
import hei.devweb.model.Joueur;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListeJoueursServlet extends HttpServlet {

	private static final long serialVersionUID = 8450039261358807762L;
	private String equipeChoisie;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Equipe> equipes = Manager.getInstance().listerEquipes();
		request.setAttribute("equipes", equipes);
		
		List<Joueur> joueurs = Manager.getInstance().listerJoueurs(equipeChoisie);
		request.setAttribute("joueurs", joueurs);
			
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/joueurs.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		List<Equipe> equipes = Manager.getInstance().listerEquipes();
		request.setAttribute("equipes", equipes);
		
		equipeChoisie=request.getParameter("equipeChoisie");
		List<Joueur> joueurs = Manager.getInstance().listerJoueurs(equipeChoisie);
		request.setAttribute("joueurs", joueurs);
		
		request.setAttribute("equipeChoisie", equipeChoisie);
			
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/joueurs.jsp");
		view.forward(request, response);
	}
	
}
