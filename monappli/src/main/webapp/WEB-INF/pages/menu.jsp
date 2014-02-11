<nav>
	<ul>
		<li class="<c:if>  ${pageSelectionnee == 'index' ? 'pageactive' : ''} </c:if>">
			<a href="index">Accueil</a>
		</li>
		<li class="<c:if>  ${pageSelectionnee == 'equipes' ? 'pageactive' : ''} </c:if>">
			<a href="equipes">Equipes</a>
		</li>
		<li class="<c:if>  ${pageSelectionnee == 'matchs' ? 'pageactive' : ''} </c:if>">
			<a href="matchs?groupe=A">Matchs</a>
		</li>
		<li class="<c:if>  ${pageSelectionnee == 'stades' ? 'pageactive' : ''} </c:if>">
			<a href="stades">Stades</a>
		</li>
		<li class="<c:if>  ${pageSelectionnee == 'joueurs' ? 'pageactive' : ''} </c:if>">
			<a href="joueurs">Joueurs</a>
		</li>
	</ul>
</nav>