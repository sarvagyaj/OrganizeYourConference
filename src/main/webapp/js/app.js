$(document).ready(function() {
	var hidden= false;
	if($("#email_error").text() !="" || $("#password_error").text() !="")
	{
		hidden= true;		
		$(".loginDiv").slideDown(500);
		$(".loginDiv").show();
	}
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
	$("#p1_login").click(function() {
		hidden= true;		
		$(".loginDiv").slideDown(500);
		$(".loginDiv").show();
	});
	$("#p2_login").click(function() {
		hidden= true;		
		$(".loginDiv").slideDown(500);
		$(".loginDiv").show();
	});
	$("#p3_login").click(function() {
		hidden= true;		
		$(".loginDiv").slideDown(500);
		$(".loginDiv").show();
	});
	$("#p4_login").click(function() {
		hidden= true;		
		$(".loginDiv").slideDown(500);
		$(".loginDiv").show();
	});
	$("#p5_login").click(function() {
		hidden= true;		
		$(".loginDiv").slideDown(500);
		$(".loginDiv").show();
	});	
	$("#p6_login").click(function() {
		hidden= true;		
		$(".loginDiv").slideDown(500);
		$(".loginDiv").show();
	});
	
});