<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<c:set var="pageSelectionnee" value="equipes" scope="request"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Les équipes présentes au mondial</title>
		<link rel="icon" type="image/jpg" href="images/worldcup2014.jpg" />
		<link href="css/style.css" rel="stylesheet">
		<link rel="stylesheet" href="css/style-less720.css" media="screen and (max-width:720px)" /> 		
	</head>
	<body>
		<!-- Header -->
		<jsp:include page="header.jsp"/>
		
		<!-- Menu -->
		<jsp:include page="menu.jsp"/>
		
		<!-- Affichage des équipes par groupe -->
		<c:forEach var="groupe" items="${groupes}" varStatus="listeGroupe" >
			<table class="equipe" >
				<thead>
					<tr>
						<th colspan="2">Groupe ${groupe}</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="equipe" items="${equipesParGroupe[listeGroupe.index]}">
						<tr>
							<td><img class="drapeau" alt="${equipe.nomPays}" src="${equipe.drapeau}"/></td>
							<td>${equipe.nomPays}</td>
						</tr>							
					</c:forEach>
				</tbody>
			</table>
		</c:forEach>
		
		<!-- Footer -->
		<jsp:include page="footer.jsp"/>
	</body>
</html>