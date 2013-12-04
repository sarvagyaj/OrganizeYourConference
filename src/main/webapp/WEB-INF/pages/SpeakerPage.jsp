<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Speaker Page</title>
<meta name="description" content="Guest Page">

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="js/appSpeaker.js"></script>

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
}
</style>

</head>

<body>
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

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span2">
				<div class="well sidebar-nav" height="90%">
					<ul class="nav nav-list">
						<li><a class="nav-header" href="#">Home</a></li>
						<li class="nav-header">Profile</li>
						<li><a class="nav-list" href="SpeakerPage">View/Edit
								Profile</a></li>
						<li class="nav-header">Conference</li>
						<li><a class="nav-list" href="#">Create
								Conference</a></li>
						<li><a class="nav-list" href="ViewAllPreviousConference">Previous
								Conferences</a></li>
						<li><a class="nav-list" href="#">Register
								for Conferences</a></li>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->

			<form:form method="post" modelAttribute="speaker">
				<div class=offset3>
					<div class="span5">

						<table id="SpeakerProfile">
							<tr>
								<td><span class="label">First Name </span></td>
								<td><form:input type="text" id = "FName" path="firstName"
										placeholder="Your First Name" disabled= "true"/></td>
							</tr>
							<tr>
								<td><span class="label">Last Name </span></td>
								<td><form:input type="text" id = "LName" path="lastName"
										placeholder="Your Last Name" disabled= "true"/></td>
							</tr>
							<tr>
								<td><span class="label">Email ID</span></td>
								<td><form:input type="email" id = "EmailID" path="emailId"
										placeholder="Your Email ID" disabled= "true" /></td>
							</tr>
							<tr>
								<td><span class="label">Location</span></td>
								<td><form:input type="text" id = "Loc" path="location"
										placeholder="Your Location" disabled= "true" /></td>
							<tr>
								<td><span class="label">Job Profile</span></td>
								<td><form:input type="text" id = "Role" path="role"
										placeholder="Your job profile in Company" disabled= "true"/></td>
							</tr>
						</table>
						<br> <br>
						<button type="button" id="editSpeaker" class="btn btn-primary">Edit</button>
						<button type="submit" id="saveSpeaker" class="btn btn-primary">Save</button>
						<button type="button" id="cancelSpeaker" class="btn btn-primary">Cancel</button>
						<br>
						<br>
						<a href="http://sns.us-east-1.amazonaws.com/?Name=Sample-Topic&Action=CreateTopic&SignatureVersion=2&SignatureMethod=HmacSHA256&Timestamp=2013-12-03T03%3A00%3A00.000Z&AWSAccessKeyId=770585377988&Signature=gfzIF53exFVdpSNb8AiwN3Lv%2FNYXh6S%2Br3yySK70oX4%3D">Click </a>to upload documents to DropBox
						</div>
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>