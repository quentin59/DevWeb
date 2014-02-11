package hei.devweb.controllers;

import hei.devweb.metier.Manager;
import hei.devweb.model.Equipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListeEquipesServlet extends HttpServlet {

	private static final long serialVersionUID = 2179311288182046843L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Equipe> equipes = Manager.getInstance().listerEquipes();
		request.setAttribute("equipes", equipes);
		
		List<String> groupes = Manager.getInstance().listerGroupes();
		request.setAttribute("groupes", groupes);
		
		List<List<Equipe>> equipesParGroupe = new ArrayList<List<Equipe>>();
		for (String groupe : groupes) {
			List<Equipe> equipe = Manager.getInstance().listerEquipes(groupe);
			equipesParGroupe.add(equipe);
		}
		request.setAttribute("equipesParGroupe", equipesParGroupe);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/equipes.jsp");
		view.forward(request, response);
	}
	
}
