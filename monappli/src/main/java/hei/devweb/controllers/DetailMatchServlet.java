package hei.devweb.controllers;


import hei.devweb.metier.Manager;
import hei.devweb.model.Match;




import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class DetailMatchServlet extends HttpServlet{

	private static final long serialVersionUID = -8088391917325622862L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	request.setCharacterEncoding("UTF-8");
	int idMatch=Integer.parseInt(request.getParameter("id"));
	Match match = Manager.getInstance().getMatch(idMatch);
	
	// Si le match n'est pas complété, on n'envoie rien
	
	if(match.isCompleter())
	{
		Gson gson = new Gson();
		String matchJson = gson.toJson(match);		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.append(matchJson);
	}
	
	}
}
