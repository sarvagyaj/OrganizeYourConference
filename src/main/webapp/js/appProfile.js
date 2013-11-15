$(document).ready(function() {
	$("#edit").click(function() {
		alert("You can edit");
		  $("#FName").prop("disabled", false);
		  $("#LName").prop("disabled", false);
		  $("#EmailID").prop("disabled", false);
		  $("#Loc").prop("disabled", false);
	 });
	
	$("#save").click(function() {
		 alert("Saving...");
		  $("#FName").prop("disabled", true);
		  $("#LName").prop("disabled", true);
		  $("#EmailID").prop("disabled", true);
		  $("#Loc").prop("disabled", true);
	 });
	
	$("#cancel").click(function() {
		alert("Cancel..");
		  $('#FName').val("");
		  $('#LName').val("");
		  $('#EmailID').val("");
		  $('#Loc').val("");
		  $("#FName").prop("disabled", true);
		  $("#LName").prop("disabled", true);
		  $("#EmailID").prop("disabled", true);
		  $("#Loc").prop("disabled", true);
     });
});