package hei.devweb.controllers;

import hei.devweb.metier.Manager;
import hei.devweb.model.Match;
import hei.devweb.model.Stade;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListeMatchsServlet extends HttpServlet {

	private static final long serialVersionUID = 2179311288182046843L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<String> groupes = Manager.getInstance().listerGroupes();
		request.setAttribute("groupes", groupes);
		
		String groupeSelectionne = request.getParameter("groupe");
		request.setAttribute("groupeSelectionne", groupeSelectionne);
		
		// On controle si l'utilisateur ne modifie pas les paramètres de l'url
		// en mettant autre chose qu'un groupe connu.
		
		if (!groupes.contains(groupeSelectionne))
		{
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/erreur.jsp");
			view.forward(request, response);
		}
		
		else
		{
			// Si les matchs ne sont pas générés, il faut les générer
			boolean generer = Manager.getInstance().isGenerer(groupeSelectionne);
			if (!generer)
			{
				Manager.getInstance().genererMatchs(groupeSelectionne);
			}
			
			List<Match> matchs = Manager.getInstance().listerMatchs(groupeSelectionne);
			request.setAttribute("matchs", matchs);
		
			List<Stade> stades = Manager.getInstance().listerStades();
			request.setAttribute("stades", stades);
		
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/matchs.jsp");
			view.forward(request, response);	
		}
		
	}
	
}
