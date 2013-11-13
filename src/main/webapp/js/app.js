$(document).ready(function() {
	var hidden= false;
	$("#oyc_login").click(function() {		
		if(hidden){
			$(".loginDiv").slideUp(500);
		}
		else
			{
			$(".loginDiv").slideDown(500);
			$(".loginDiv").show();
			}
		hidden= !hidden;			
		});
	$("#oyc-login-signup-close").click(function() {
		$(".loginDiv").slideUp(500);
		hidden=false;
	});
});