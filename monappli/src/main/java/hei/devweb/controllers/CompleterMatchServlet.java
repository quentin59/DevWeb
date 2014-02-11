package hei.devweb.controllers;

import hei.devweb.metier.Manager;
import hei.devweb.model.Match;

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

public class CompleterMatchServlet extends HttpServlet {


	private static final long serialVersionUID = 4969504773061363085L;
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		int idMatch=Integer.parseInt(request.getParameter("idMatch"));
		String equipe1 = request.getParameter("equipe1");
		String equipe2 = request.getParameter("equipe2");
		int score1 = Integer.parseInt(request.getParameter("score1"));
		int score2 = Integer.parseInt(request.getParameter("score2"));
		String stade = request.getParameter("stade");
		int affluence = Integer.parseInt(request.getParameter("affluenceMatch"));
		Date dateMatch = null;
		try {
			dateMatch = dateFormat.parse(request.getParameter("dateMatch"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Match match = new Match(idMatch,equipe1, equipe2, score1, score2, stade, affluence, dateMatch,true);
		Manager.getInstance().completerMatch(match);
				
		Gson gson = new Gson();
		String matchJson = gson.toJson(match);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.append(matchJson);
	}
}
