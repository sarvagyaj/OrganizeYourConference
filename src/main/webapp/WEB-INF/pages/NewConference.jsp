<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="Create Conference">


<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script type="text/javascript" src="js/bootstrap-2.2.2.min.js"></script>
<script type="text/javascript" src="js/bootstrap-timepicker.min.js"></script>
<script src="js/app.js"></script>

<script>
$(function() {
$( "#datepicker").datepicker();
});
</script>

<script type="text/javascript">
$('#timepicker').timepicker({
minuteStep: 5,
showInputs: false,
disableFocus: true
});
</script>

<link type="text/css" href="css/bootstrap.min.css" />
<link type="text/css" href="css/bootstrap-timepicker.min.css" />
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/ParticipantSpeaker.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">

<title>Create Conference</title>

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
}
</style>
</head>
<body>
<p style="display:none" id="userrole">${user.role}</p>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="navbar-brand"
					style="color: white; font-size: 30px; font-style: italic;" href="#">Organize
					Your Conference</a>
				<p align="right" class="navbar-brand navbar-pull-right">
					Logged in as <a class="navbar-brand navbar-pull-right" href="#">${UserName}</a>
				</p>
			</div>
		</div>
	</div>
	<div class="container-fluid" >
     <div class="row-fluid">
        <div class="span2">
          <div class="well sidebar-nav" height="90%">
            <ul class="nav nav-list">
              <li ><a class="nav-header" href="UserHome">Home</a></li>
              <li class="nav-header"> Profile</li>
              <li><a class="nav-list" href="ProfilePage">View/Edit Profile</a></li>
              <li class="nav-header">Conference</li>
              <li><a id="creatconference" class="nav-list" href="NewConference">Create Conference</a></li>
              <li><a id="prevconference" class="nav-list" href="ViewAllPreviousConference">Previous Conferences</a></li>
              <li><a id="registeredconference" class="nav-list" href="RegisteredConference">Registered Conferences</a></li>
              
              </br></br> </br></br> </br></br>
              <li class="nav-header"><a class="nav-list"  style="color:white" id="idlogout" href="Logout">Logout</a></li>
            </ul>
          </div><!--/.well -->
			</div>
			<!--/span-->
			<div class="span5">
				<form:form method="post" modelAttribute="conference"
					class="form-signin">
					<div class=offset3>
						<table id="confdetails">
							<tr>
								<td><span class="label">Topic</span></td>
								<td><form:input type="text" path="topic"
										placeholder="Topic" /></td>
							</tr>
							<tr>
								<td><span class="label">Description</span></td>
								<td><form:input type="text" path="description"
										placeholder="Description" /></td>
							</tr>
							<tr>
								<td><span class="label">Venue</span></td>
								<td><form:input type="text" path="venue"
										placeholder="Venue" /></td>
							</tr>
							<tr>
								<td><span class="label">Date</span></td>
								<td><form:input type="text" id = "datepicker" path="date"
										placeholder="mm/dd/yyyy" /></td>
							</tr> 
							<tr>
								<td><span class="label">Time</span></td>
								<td><form:input type="text" id = "timepicker" path="time"
										placeholder="hh:mm" /></td>
							</tr>
							<tr>
								<td><span class="label">Name of the Speaker</span></td>
								<td><form:input type="text" path="speaker_name"
										placeholder="Speaker's Name" /></td>
							</tr>
							<tr>
								<td><span class="label">LinkedIn link of Speaker</span></td>
								<td><form:input type="text" path="speaker_link"
										placeholder="Speaker's Linkedin link" /></td>
							</tr>
							<tr>
								<td><span class="label">Email of Speaker</span></td>
								<td><form:input type="email" path="speaker_email"
										placeholder="Speaker's Email ID" /></td>
							</tr>
							<tr>
								<td><span class="label">Send Invites to</span></td>
								<td><form:input type="text" path="participants"
										placeholder="Email IDs seperated by commas" /></td>
							</tr>
						</table>
						<br> <br>
						<button type="submit" id="create" class="btn btn-primary">Create</button>
						<button type="button" id="edit" class="btn btn-primary">Edit</button>
						<button type="button" id="cancelbtn" class="btn btn-primary">Cancel</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$( document ).ready(function() {
		pageLoad();
		enableLinks();
	});
	
	function pageLoad(){
		
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
	</script>
</body>
</html>
