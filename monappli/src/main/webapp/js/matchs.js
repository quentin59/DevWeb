$(document).ready(function() {
	$(".detailmatch").click(function(){
		var idMatch = this.id;
        recupereDetailMatch(idMatch);
        
	});
	
	$(".completermatch").click(function(){
		var idMatch=this.id;
		var nomEquipe1 = $(this).data("equipe1");
        var nomEquipe2 = $(this).data("equipe2");
        var completer = $(this).data("completer");
        if (!completer)
        	{
        	$("#equipe1").text(nomEquipe1);
    	    $("#equipe2").text(nomEquipe2);
    	    $('#equipeForm1').val(nomEquipe1);
    	    $('#equipeForm2').val(nomEquipe2);
    	    $("#idMatch").text(idMatch);
    	    $('#idMatchForm').val(idMatch);
    		$("#matchForm").slideDown();
    		$("#erreurForm2").slideUp();
    		$("#articlematch").slideUp();
        	}
        else
        	{
        	$("#erreurForm2").slideDown();
        	$("#articlematch").slideUp();
        	}
		
		
	});
	
	$("#matchForm").submit(function(event) {
		$.post("completermatch", {idMatch:$("#idMatchForm").val(), score1:$("#score1Form").val(), score2:$("#score2Form").val(), stade:$("select[name='stade'] > option:selected").val(), affluenceMatch:$("#affluenceForm").val(), dateMatch:$("#dateForm").val()}).done(function(data){
			
			$("#scoreMatchCompleter_"+data.idMatch).text(data.scoreEquipe1+" - "+data.scoreEquipe2);
			$("#idMatchForm").val('');
			$("#score1Form").val('');
			$("#score2Form").val('');
			$("#dateForm").val('');
			$("#affluenceForm").val('');
			$("select[name='stade'] > option:selected").text('');		
			$("#matchForm").hide();
		}).fail(function(){
			$(".incompletForm").slideDown();		
		});
		event.preventDefault();
	});
	
	 
});

var recupereDetailMatch = function (idMatch) 
{
	$.ajax({url:"detailmatch", type:"POST", data:{
		id:idMatch,
	}}).done(function(match) {
		if (match)
			{
			$("#e1").text(match.equipe1);
			$("#e2").text(match.equipe2);
			$("#s1").text(match.scoreEquipe1);
			$("#s2").text(match.scoreEquipe2);
			$("#articleDate").text(match.dateMatch);
			$("#articleStade").text(match.stade);
			$("#articleAffluence").text(match.affluence);
			$("#articlematch").slideDown();
			$("#erreurForm").slideUp();
			$("#matchForm").slideUp();
			$("#erreurForm2").slideUp();
			}
		else
			{
			$("#articlematch").slideUp();
			$("#erreurForm").slideDown();
			$("#erreurForm2").slideUp();
			}
			});
};

