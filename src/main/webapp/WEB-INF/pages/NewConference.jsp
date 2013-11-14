<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="Create Conference">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="js/app.js"></script>
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-responsive.css" rel="stylesheet">
 <link href="css/ParticipantSpeaker.css" rel="stylesheet">
<title>Create Conference</title>

<style>
 body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      
      .sidebar-nav {
        padding: 9px 0;
      }
      
	
	 .navbar-pull-right {
	 	  float:none;
          padding-left: 10px;
          padding-right: 40px;
        }
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<div class="well sidebar-nav">
					<ul class="nav nav-list">
						<li class="nav-header">Profile</li>
						<!-- <li class="active"><a href="#">View</a></li> -->
						<li><a href="ProfilePage">View/Edit</a></li>
						<li class="nav-header">Conference</li>
						<li><a href="#">Create</a></li>
						<li><a href="#">View</a></li>
						<li><a href="#">Invite</a></li>
					</ul>
				</div>
				<!--/.well -->
			</div>
			<!--/span-->
			<div class="span9">
				<form:form method="post" modelAttribute="conference" class="form-signin">
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
								<td><form:input type="text" path="date"
										placeholder="mm/dd/yyyy" /></td>
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
								<td><form:input type="text" path="speaker_email"
										placeholder="Speaker's Email ID" /></td>
							</tr>
						</table>
						<br>
						<br>
						<button type="submit" id= "create" class="btn btn-primary">Create</button>
						<button type="button" id= "cancelbtn" class="btn btn-primary">Cancel</button>
					</form:form>
			</div>
		</div>
	</div>
</body>
</html>