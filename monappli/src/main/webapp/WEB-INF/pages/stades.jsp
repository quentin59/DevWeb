<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<c:set var="pageSelectionnee" value="stades" scope="request"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Les stades du mondial</title>
		<link rel="icon" type="image/jpg" href="images/worldcup2014.jpg" />
		<link href="css/style.css" rel="stylesheet">
		<link rel="stylesheet" href="css/style-less720.css" media="screen and (max-width:720px)" /> 
	</head>
	<body>
		<!-- Header -->
		<jsp:include page="header.jsp"/>
		
		<!-- Menu -->
		<jsp:include page="menu.jsp"/>
		
		<!-- Affichage des stades -->
		
		<table class="stade">
			<thead>
				<tr>
					<th>Stade</th>
					<th>Ville</th>
					<th>Capacité</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="stade" items="${stades}">
					<tr>
						<td>${stade.nom}</td>
						<td>${stade.ville}</td>
						<td>${stade.capacite}</td>
					</tr>	
				</c:forEach>
			</tbody>
		</table>
		
		<img id="emplacementstade" src="images/stades.png" alt="Emplacement des stades" />
		
		<!-- Footer -->
		<jsp:include page="footer.jsp"/>
	</body>
</html>