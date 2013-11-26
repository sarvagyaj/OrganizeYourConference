<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="Create Conference">
<!-- <link href="css/bootstrap.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet"> -->
<link href="css/ParticipantSpeaker.css" rel="stylesheet">
<link href="css/header.css" rel="stylesheet">
<title>Create Conference</title>
<style>
p.margin {
	margin-top: 70px;
	margin-bottom: 100px;
	margin-right: 50px;
	margin-left: 50px;
}

body {
	background-color: #E6FCB9;
	margin-top: 50px;
	margin-bottom: 100px;
	margin-right: 50px;
	margin-left: 50px;
}
</style>
</head>
<body>
	<header> <img id="img1" src="images/heading_green.gif" /> </header>

	<form:form method="post" modelAttribute="conference"
		class="form-signin">
		<div class="offset3">
			<h3>
				<b><font color="336600" face="Eras Demi ITC">Enter
						Conference Details</font></b>
			</h3>
		</div>
		<div class="row span3 offset1">
			<table id="confdetails">
				<tr>
					<td><span class="label">Topic</span></td>
					<td><form:input type="text" path="topic"
							placeholder="Topic of the conference" /></td>
				</tr>
				<tr>
					<td><span class="label">Description</span></td>
					<td><form:input type="text" path="description"
							placeholder="Description" /></td>
				</tr>
				<tr>
					<td><span class="label">Venue</span></td>
					<td><form:input type="text" path="venue"
							placeholder="Where is it?" /></td>
				</tr>
				<tr>
					<td><span class="label">Date</span></td>
					<td><form:input type="text" path="date"
							placeholder="mm/dd/yyyy" /></td>
				</tr>
				<!-- <tr> -->
				<!-- <td><span class="label">Time</span></td> -->
				<%-- <td><form:input type="text" path="time" placeholder="when is it"/></td>	 --%>
				<!-- </tr> -->

				<tr>
					<td><span class="label">Name of the Speaker</span></td>
					<td><form:input type="text" path="speaker_name"
							placeholder="who is the Speaker?" /></td>
				</tr>
				<tr>
					<td><span class="label">LinkedIn link of Speaker</span></td>
					<td><form:input type="text" path="speaker_link"
							placeholder="Speakers Linkedin link" /></td>
				</tr>
				<tr>
					<td><span class="label">Email of Speaker</span></td>
					<td><form:input type="text" path="speaker_email"
							placeholder="Speaker's email id" /></td>
				</tr>
				<tr></tr>
			</table>
			<div class="btn-group">
				<button class="btn">Create New Conference</button>
				<button class="btn">Cancel</button>
			</div>

		</div>
	</form:form>
</body>
</html>