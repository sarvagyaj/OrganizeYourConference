$( document ).ready(function() {
	pageLoad();
	enableLinks();
});
function pageLoad(){
	//this is to load the recent conference and other details.
	$.ajax({
		  type: "GET",
		  url: "UserHome/poojakasu",		  
		  complete: LoadView()
	});
}

function LoadView(){
	/*if(xhr.statusCode == 200)
		alert("its a success");
	else
		alert(xhr.statusCode);*/
}
//this function to enable and disable links as per the user
function enableLinks(){
	
	var str = $("#userrole").html();
	if(str == "Organizer"){
		$("#creatconference").show();
		$("#registeredconference").hide();
		$("#prevconference").show();
	}
	else if(str == "Speaker"){
		$("#creatconference").hide();
		$("#registeredconference").hide();
		$("#prevconference").show();
	}
	else if(str == "Participant"){
		$("#creatconference").hide();
		$("#registeredconference").show();
		$("#prevconference").show();
	}
}