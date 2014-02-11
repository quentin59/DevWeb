<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="pageSelectionnee" value="joueurs" scope="request"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Les joueurs du mondial</title>
		<link rel="icon" type="image/jpg" href="images/worldcup2014.jpg" />
		<link href="css/style.css" rel="stylesheet">
		<link rel="stylesheet" href="css/style-less720.css" media="screen and (max-width:720px)" /> 
		<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
		<script type="text/javascript" src="js/joueurs.js"></script>
	</head>
	<body>
		<!-- Header -->
		<jsp:include page="header.jsp"/>
		
		<!-- Menu -->
		<jsp:include page="menu.jsp"/>
		
		
		<!-- Formulaire d'ajout de joueur -->
		
		<form id="ajoutjoueur" method="post" action="ajouterjoueur" >
			<h3>
				<span id="equipeForm" >${equipeChoisie}</span>
			</h3> 
			<h3>Ajouter un joueur</h3>
			
			<label for="nomForm">Nom</label> 
			<input type="text" name="nom" id="nomForm" placeholder="Nom"><br/>
			
			<label for="prenomForm">Prénom</label> 
			<input type="text" name="prenom" id="prenomForm" placeholder="Prénom"><br/>
			
			<label for="numForm">Numéro</label> 
			<input type="text" name="num" id="numForm" placeholder="Numéro"><br/>
			
			<label for="dateForm">Date de naissance</label> 
			<input	type="date" name="dateNaissance" id="dateForm" placeholder="AAAA-MM-JJ"><br/>
			
			<input class="boutonValider" type="submit" value="Enregistrer"><br/>
			<div class="incompletForm">Tous les champs doivent être complétés.</div>
		</form>
		
		
		<!-- Formulaire de selection de l'équipe -->
		
		<label for="selectionEquipeForm">Sélectionnez une équipe</label> 
		<form id="selectionEquipeForm" method="post" action="joueurs">
		
			<select id="equipeForme" name="equipeChoisie" >
				<option value="vide" ></option>
				<c:forEach var="equipe" items="${equipes}">
	  				<option value="${equipe.nomPays}" 
	  					<c:if test="${equipe.nomPays==equipeChoisie}">selected="selected"</c:if> >${equipe.nomPays}</option>
	  			</c:forEach>
			</select>
			<input class="valider" type="submit" value="Afficher les joueurs">
		</form> 
		
		<!-- Bouton d'ajout de joueur -->
		
		<a id="ajouter" class="valider">Ajouter un joueur</a>
	
	
		<!-- Affichage des joueurs -->
		
		<table class="joueurs">
			<thead>
				<tr> 
					<th colspan="5">${equipeChoisie}</th>
				</tr>
				<tr>
					<th>Numéro</th>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Date de Naissance</th>
					<th>Supprimer</th>
				</tr>
			</thead>
			<tbody> 
				<c:forEach var="joueur" items="${joueurs}">
					<tr>
						<td>${joueur.numero}</td>
						<td>${joueur.nom}</td>
						<td>${joueur.prenom}</td>
						<td><fmt:formatDate value="${joueur.dateNaissance}" pattern="dd MMM yyy"/></td>
						<td>
							<span class="supprimer" id="joueur_${joueur.idJoueur}" >
								<img src="images/supprimer.png" alt="Supprimer le joueur" title="Supprimer le joueur"/>
							</span>
						</td>
					</tr>	
				</c:forEach>
			</tbody>						
		</table>
		
		<!-- Footer -->
		<jsp:include page="footer.jsp"/>
	</body>
</html>