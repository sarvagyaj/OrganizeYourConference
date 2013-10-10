<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
<!DOCTYPE html>   
<html lang="en">   
<head>   
<meta charset="utf-8">   
<title>Speaker Page</title>   
<meta name="description" content="Guest Page">  
<link href="css/ParticipantSpeaker.css" rel="stylesheet">
<link href="css/header.css" rel="stylesheet">
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
background-color:#E6FCB9;
margin-top:50px;
margin-bottom:100px;
margin-right:50px;
margin-left:50px;
}
</style>
</head> 
 
<body>  
<header>
<img id="img1" src="images/heading_green.gif" />
</header>
<!-- <img src="images/advertisement.jpg" width="180" height="200" align = "right">  -->
<div class="offset4">
<h3><b><font color = "336600" face="Eras Demi ITC">Guest Speaker Profile</font></b></h3></div>
<div class="row">  
<div class="span3">
<div class="offset3">
<form:form method="post" modelAttribute="speaker">
<p>
	<span class="label">First Name </span> </p>
	<form:input type="text" path="firstName"  placeholder="Your First Name"/>

<p>
	<span class="label">Last Name </span> </p>
	<form:input type="text" path="lastName"  placeholder="Your last Name"/>

<p>
	<span class="label">Email ID</span></p>
	 <form:input type="email" path="emailId" placeholder="Your Email ID"/>

<p>
	<span class="label">Location</span> </p>
	<form:input type="text" path="location" placeholder="Your Location"/>

<p>
	<span class="label">Job Profile</span> </p>
	<form:input type="text" path="role" placeholder="Your job profile in Company"/>
<br>
<br>
			
<!-- <div class="btn-group">
<button class="btn"> Edit </button>
<button class="btn">Save</button>
<button class="btn">Upload Files</button>
</div> -->
</form:form>

</div>
</div>
</div>

</body>  
</html>