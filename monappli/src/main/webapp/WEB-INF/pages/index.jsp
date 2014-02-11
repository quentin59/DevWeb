<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageSelectionnee" value="index" scope="request"></c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Coupe du monde 2014</title>
		<link rel="icon" type="image/jpg" href="images/worldcup2014.jpg" />
		<link href="css/style.css" rel="stylesheet">
		<link rel="stylesheet" href="css/style-less720.css" media="screen and (max-width:720px)" /> 
	</head>
	<body>
		<!-- Header -->
		<jsp:include page="header.jsp"/>
		
		<!-- Menu -->
		<jsp:include page="menu.jsp"/>
		
		<!-- Contenu -->
		<article class="introduction">
			<p>Bienvenue sur le site de présentation de la coupe du monde de football 2014.</p>
			<p>La XXe édition de cette compétition se déroulera du 12 juin au 13 juillet 2014 au Brésil</p>
			<p>Sur ce site, vous avez la possibilité de consulter les équipes participantes, de voir les stades dans lesquels se dérouleront les matchs. Mais aussi de consulter et de modifier la liste des joueurs par pays participants, ainsi que de rentrer les résultats d’une rencontre.</p>
			<p>Pour les phases de groupe de cette coupe du monde, il y a 8 groupes de 4 équipes. Les 2 premiers de chaque poule sont qualifiés pour la phase finale du tournoi.</p>
		</article>
		
		<!-- Footer -->
		<jsp:include page="footer.jsp"/>
	</body>
</html>