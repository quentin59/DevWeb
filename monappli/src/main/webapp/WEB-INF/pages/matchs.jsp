<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<c:set var="pageSelectionnee" value="matchs" scope="request"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Les matchs du mondial</title>
		<link rel="icon" type="image/jpg" href="images/worldcup2014.jpg" />
		<link href="css/style.css" rel="stylesheet">
		<link rel="stylesheet" href="css/style-less720.css" media="screen and (max-width:720px)" /> 
		<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
		<script type="text/javascript" src="js/matchs.js"></script>
	</head>
	<body>
		<!-- Header -->
		<jsp:include page="header.jsp"/>
		
		<!-- Menu -->
		<jsp:include page="menu.jsp"/>
		
		<!-- Affichage des matchs -->
	
		<label for"selectionGroupeForm">Sélectionnez un groupe</label>
		<form id="selectionGroupeForm" method="get" action="matchs">
			<select id="groupeForm" name="groupe" >
				<c:forEach var="groupe" items="${groupes}">
	  				<option value="${groupe}"
	  				 <c:if test="${groupeSelectionne==groupe}">selected="selected"</c:if>
	  				>Groupe ${groupe}</option>
	  			</c:forEach>
			</select>
			<input class="boutonValider" type="submit" value="Enregistrer">
		</form>
		
		<table class="listeMatchs">
			<c:forEach var="match" items="${matchs}">
				<tr>
					<td>${match.equipe1}</td>
					<td><c:if test="${match.completer}">${match.scoreEquipe1} - ${match.scoreEquipe2}</c:if><span id="scoreMatchCompleter_${match.idMatch}"></span></td> 
					<td>${match.equipe2}</td>
					<td>
						<span  class="detailmatch" id="${match.idMatch}" >
							<img src="images/boutonDetail.png" alt="Détail du match" title="Détail du match"/>
						</span>
					</td>
					<td><span  class="completermatch" 
								data-equipe1="${match.equipe1}" 
								data-equipe2="${match.equipe2}" 
								data-completer="${match.completer}" 
								id="${match.idMatch}" >Compléter le match</span></td>
				</tr>
			</c:forEach>
		</table>
		
		<div id="erreurForm">Vous ne pouvez pas voir le détail de ce match, il n'a pas été complété.</div>
		<div id="erreurForm2">Le match est déjà complété</div>
		
		
		<!-- Formulaire pour compléter un match -->
		
		<form id="matchForm" method="post" action="completermatch" >
			<h3>Feuille de match</h3>
			<h4><span id="equipe1"></span> - <span id="equipe2"></span></h4>
			
			<input type="hidden" name="idMatch" id="idMatchForm"/>
			
			<label for="score1Form">Entrez le score du match</label> 
			<input	type="number" name="score1" id="score1Form" size="2"> - <input	type="number" name="score2" id="score2Form" size="2"><br/>
			
			<label for="dateForm">Date du match</label> 
			<input	type="date" name="dateMatch" id="dateForm" placeholder="AAAA-MM-JJ"><br/>
			
			<label for="stadeForm">Stade</label> 
			<select id=stadeForm" name="stade" >
					<option value="vide"></option>
				<c:forEach var="stade" items="${stades}">
	  				<option value="${stade.nom}">${stade.nom}</option>
	  			</c:forEach>
			</select><br/>
			
			<label for="affluenceForm">Nombre de spectateurs</label> 
			<input	type="number" name="affluenceMatch" id="affluenceForm" placeholder="Nombre de spectateurs"><br/>
			
			<input class="boutonValider" type="submit" value="Enregistrer"><br/>
			<div class="incompletForm">Tous les champs doivent être complétés.</div>
		</form>
		
		
		<!-- Affichage du détail d'une rencontre -->
		
		<article id="articlematch">
			<ul>
				<li>Match : <span id="e1" ></span> - <span id="e2"></span></li>
				<li>Score : <span id="s1" value="vide"></span> - <span id="s2"></span>
				<li>Date : <span id="articleDate"></span></li>
				<li>Stade : <span id="articleStade"></span></li>
				<li>Affluence : <span id="articleAffluence"></span> personnes</li>
			</ul>
		</article>
		
		<!-- Footer -->
		<jsp:include page="footer.jsp"/>
	</body>
</html>