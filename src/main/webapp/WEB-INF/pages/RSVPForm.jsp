<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RSVP</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/ParticipantSpeaker.css" rel="stylesheet">
<link href="../css/bootstrap-responsive.css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/ParticipantSpeaker.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">

<style type="text/css">
body {
	padding-top: 60px;
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}
.navbar-pull-right {
	float: none;
	padding-left: 10px;
	padding-right: 40px;
}
.errorcss{
	color: #000;
	background-color: #ffEEEE;
	border: 2px solid #ff0000;
	padding:8px;
	padding-left:290px;
	margin:4px;
}
</style>
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="navbar-brand"
					style="color: white; font-size: 30px; font-style: italic;" href="#">Organize Your Conference</a>				
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span2">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li><a id = "navheader" class="nav-header" href="../LoginPage">Login</a></li>

					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<div></br></br></br>
				<h2><p style="padding-left:290px">RSVP Form</p></h2>
				<b><span style="padding-left:60px;padding-top:20px" id="msg">${msg}</span>	</b>
				<form:form method="post" modelAttribute="user" >					
					<div id ="rsvpform" class=offset3>
						<table id="signindetails">
							<tr>
							<td><span class="label">First Name</span></td>
							<td><form:input type="text" path="firstName" placeholder="Your First Name" /></td>
							</tr>
							<tr>
							<td><span class="label">Last Name</span></td>
							<td><form:input type="text" path="lastName" placeholder="Your last Name" /></td>
							</tr>
							<tr>
							<td><span class="label">Email</span></td>
							<td><form:input type="email" path="emailId" placeholder="Your Email ID" />
							</tr>					
						</table>
						<br> <br>
						<button type="submit" id="yesSubmit" class="btn btn-primary">Yes</button>
						<button type="button" id="noSubmit" class="btn btn-primary">No</button>						
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<script>
	$( document ).ready(function() {
		if($("#msg").html() != ""){
			$("#rsvpform").hide();
			$("#navheader").href("LoginPage");
		}
		$("#noSubmit").click(function(){
			$("#msg").html("Thanks! Your Response has been recorded!!");
			$("#rsvpform").hide();
		});
	});
	</script>
</body>
</html>
