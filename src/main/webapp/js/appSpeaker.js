$(document).ready(function() {
	$("#editSpeaker").click(function() {
		alert("You can edit");
		  $("#FName").prop("disabled", false);
		  $("#LName").prop("disabled", false);
		  $("#EmailID").prop("disabled", false);
		  $("#Loc").prop("disabled", false);
		  $("#Role").prop("disabled", false);
	 });
	
	$("#saveSpeaker").click(function() {
		 alert("Saving...");
		  $("#FName").prop("disabled", true);
		  $("#LName").prop("disabled", true);
		  $("#EmailID").prop("disabled", true);
		  $("#Loc").prop("disabled", true);
		  $("#Role").prop("disabled", true);
	 });
	
	$("#cancelSpeaker").click(function() {
		alert("Cancel..");
		  $('#FName').val("");
		  $('#LName').val("");
		  $('#EmailID').val("");
		  $('#Loc').val("");
		  $('#Role').val("");
		  $("#FName").prop("disabled", true);
		  $("#LName").prop("disabled", true);
		  $("#EmailID").prop("disabled", true);
		  $("#Loc").prop("disabled", true);
		  $("#Role").prop("disabled", true);
     });
});