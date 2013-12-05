$(document).ready(function() {
	$("#edit").click(function() {
		  $("#FName").prop("disabled", false);
		  $("#LName").prop("disabled", false);
		  $("#password").prop("disabled", false);
		  $("#Loc").prop("disabled", false);
		  $("#position").prop("disabled", false);
	 });
	
	/*$("#save").click(function() {
		 alert("Saving...");
		  $("#FName").prop("disabled", true);
		  $("#LName").prop("disabled", true);
		  $("#password").prop("disabled", true);
		  $("#Loc").prop("disabled", true);
		  $("#position").prop("disabled", true);

	 });*/
	
	
	
	$("#cancel").click(function() {
		//alert("Cancel..");
		 /* $('#FName').val("");
		  $('#LName').val("");
		  $('#password').val("");
		  $('#Loc').val("");
		  $("#position").val("");*/
		  location.reload();
		  $("#FName").prop("disabled", true);
		  $("#LName").prop("disabled", true);
		  $("#password").prop("disabled", true);
		  $("#Loc").prop("disabled", true);
		  $("#position").prop("disabled", true);
     });
});