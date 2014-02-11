package hei.devweb.controllers;

import hei.devweb.metier.Manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SupprimerJoueurServlet extends HttpServlet {

	private static final long serialVersionUID = -7929730709034636790L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int idJoueur= Integer.parseInt(request.getParameter("id"));
		Manager.getInstance().supprimerJoueur(idJoueur);
	}
}
