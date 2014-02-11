package hei.devweb.controllers;

import hei.devweb.metier.Manager;
import hei.devweb.model.Stade;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListeStadesServlet extends HttpServlet {

	private static final long serialVersionUID = 2179311288182046843L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Stade> stades = Manager.getInstance().listerStades();
		request.setAttribute("stades", stades);
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/stades.jsp");
		view.forward(request, response);
	}
	
}