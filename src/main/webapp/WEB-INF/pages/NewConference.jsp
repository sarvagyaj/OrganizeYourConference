<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="Create Conference">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<link href="css/header.css" rel="stylesheet">
<link href="css/ParticipantSpeaker.css" rel="stylesheet">
<title>Create Conference</title>
<style>
p.margin
{
margin-top:70px;
margin-bottom:100px;
margin-right:50px;
margin-left:50px;
}

body
{
background-color:#F0F0F0;
margin-top:50px;
margin-bottom:100px;
margin-right:50px;
margin-left:50px;
}
</style>
</head>
<body>
<header>
    <img id="img1" src="images/heading1.jpg" />
</header>
<img src="images/adv.JPG" width="200" height="200" align = "right"> 
<form:form method="post" modelAttribute="newconference">
<div>
<table  id="confdetails">
<tr>
<td>Topic</td>
<td><form:input type="text" path="topic" placeholder="Topic of the conference"/></td>	
</tr>
<tr>
<td>Description</td>
<td><form:input type="text" path="description" placeholder="Description"/></td>	
</tr>
<tr>
<td>Venue</td>
<td><form:input type="text" path="venue" placeholder="Where is it?"/></td>	
</tr>
<tr>
<td>Date</td>
<td><form:input type="text" path="date" placeholder="mm/dd/yyyy"/></td>	
</tr>
<tr>
<td>Time</td>
<td><form:input type="text" path="time" placeholder="when is it"/></td>	
</tr>

<tr>
<td>Name of the Speaker</td>
<td><form:input type="text" path="speaker_name" placeholder="who is the Speaker?"/></td>	
</tr>
<tr>
<td>LinkedIn link of Speaker</td>
<td><form:input type="text" path="speaker_link"  placeholder="Speakers Linkedin link"/></td>	
</tr>
<tr>
<td>Email of Speaker</td>
<td><form:input type="text" path="speaker_email"  placeholder="Speaker's email id"/></td>	
</tr>
<tr></tr>
</table>
<button class="btn">Create New Conference</button>
<button class="btn">Cancel</button>
</div>
</form:form>
</body>
</html>