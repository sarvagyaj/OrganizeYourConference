<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
<meta name="description" content="Sign Page">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="js/app.js"></script>

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
.error {
	color: #ff0000;
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
					style="color: white; font-size: 30px; font-style: italic;" href="#">Organize
					Your Conference</a>
				
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span2">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li><a class="nav-header" href="LoginPage">Home</a></li>

					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<div></br></br></br>
				<p style="padding-left:290px">Sign Up for a new Account!!<p>
					
				<form:form method="post" modelAttribute="user" action="/SignUp" >
				<form:errors path="*" cssClass="errorcss" element="div"/>
					
					<div class=offset3>
						<table id="signindetails">
							<tr>
							<td><span class="label">First Name</span></td>
					    <td><form:input type="text" path="firstName" placeholder="First Name" /></td>	
						<td><form:errors path="firstName" cssClass="error" /></td>
							</tr>
							<tr>
								<td><span class="label">Last Name</span></td>
					<td><form:input type="text" path="lastName"
						placeholder="last Name" /></td>
						<td><form:errors path="lastName" cssClass="error" />	</td>
							</tr>
							<tr>
							<td>
							<label for="type">User Type: </label></td>
						        <td><form:radiobutton path="role" value="Organizer" />Organizer
								<form:radiobutton path="role" value="Speaker" />Speaker
								<form:radiobutton path="role" value="Participant" />Participant
							</td>
							</tr>
							
							<tr>
							<td><span class="label">Email Address</span></td>
							<td><form:input type="email" path="emailId" placeholder="Email ID" />
							</td><td><form:errors path="emailId" cssClass="error" />	</td>
							</tr>
							
							<tr>
								<td><span class="label">Password</span></td>
								<td><form:input type="password" path="password" placeholder="Password" />
								</td><td><form:errors path="password" cssClass="error" />	</td>
							</tr>
							
							<tr>
								<td><span class="label">Confirm Password</span></td>
								<td><form:input type="password" path="confirmPassword" placeholder="Confirm Password" />
								 </td><td><form:errors path="confirmPassword" cssClass="error" /></td>
							</tr>
							
							<tr>
								<td><span class="label">Location</span></td>
								<td><form:input type="text" path="location" placeholder="Location" /><td>
										
							</tr>		
						<tr>
							<td><span class="label">Position</span>	</td>			
							<td><form:input type="text" path="position" placeholder="Position" /></td>					
						</tr>					
						</table>
						<br> <br>
						<button type="submit" id="create" class="btn btn-primary">Create</button>						
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>
