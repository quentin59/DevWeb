$(document).ready(function() {
		
	$("#ajouter").click(function(){
		$("#ajouter").hide();
		$("#aucun_joueur").hide();
		if($(window).width()>700)
			{
			$("table.joueurs").css("left","350px");
			$("table.joueurs").css("top","-50px");
			}
		else
			{
			$("table.joueurs").css("top","350px");
			$("#ajoutjoueur").css("top","350px");			
			}
		
		$("#ajoutjoueur").show();
		});
	
	$("#ajoutjoueur").submit(function(event) {
		$.post("ajouterjoueur", {nom:$("#nomForm").val(), prenom:$("#prenomForm").val(), num:$("#numForm").val(), dateNaissance:$("#dateForm").val(), equipe:$("#equipeForm").text()}).done(function(data){
			
			$("table.joueurs").append('<tr><td>'+data.numero+'</td><td>'+data.nom+'</td><td>'+data.prenom+'</td><td>'+formaterDate(data.dateNaissance)+'</td><td><span class="supprimer" id="joueur_'+data.idJoueur+'"><img src="images/supprimer.png" alt="Supprimer le joueur" title="Supprimer le joueur"/></span></td></tr>');
			$("#nomForm").val('');
			$("#prenomForm").val('');
			$("#numForm").val('');
			$("#dateForm").val('');
			$("#equipeForm").val('');
			$("#ajouter").show();
			$("#ajoutjoueur").hide();
			$(".supprimer").click(function(){
				var idJoueur=this.id.substring(7);
				supprimerJoueur(idJoueur);
			});
		}).fail(function(){
			$(".incompletForm").slideDown();		
		});
		event.preventDefault();
			});
	
	var equipeSelectionnee=$("#equipeForme").val();
	if (equipeSelectionnee=="vide")
		{
		$("table.joueurs").css("display","none");
		$("a#ajouter").css("display","none");
		}
	
	$(".supprimer").click(function(){
		var idJoueur=this.id.substring(7);
		supprimerJoueur(idJoueur);
	});
	

	
});
	
	
	
var supprimerJoueur = function(idJoueur) {
	$.post("supprimerjoueur", {id:idJoueur}).done(function(data) {
		$("#joueur_" + idJoueur).parent().parent().remove();
	});
};

var formaterDate = function(date) {
	mois = date.substring(0,4);
	if (mois!="mai ")
	{
		if (date.substring(6,7)==',')
		{
		jour = 0+date.substring(5,6);
		}
		else
		{
		jour = date.substring(5,7);
		}
		annee = date.substring(8,13);
	}
	else
	{
		if (date.substring(5,6)==',')
		{
		jour = 0+date.substring(4,5);
		}
		else
		{
		jour = date.substring(4,6);
		}
		annee = date.substring(7,12);
	}
	
	return(jour+' '+mois+' '+annee);
};