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
<img src="images/adv.JPG" width="180" height="200" align = "right"> 
<div class="offset3">
<h3><b><font color = "3333CC" face="Eras Demi ITC">Guest Speaker Profile</font></b></h3></div>
<div class="span3">  
<div class="offset2">
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
	<span class="label">Role</span> </p>
	<form:input type="text" path="role" placeholder="Your Role in Company"/>

			
<div class="btn-group">
<a href="index.jsp"><button class="btn"> Edit </button></a>
<a href="index.jsp"><button class="btn">Save</button></a> 
<a href="index.jsp"><button class="btn">Upload Files</button></a> 
</div>
</form:form>


</div>
</div>

</body>  
</html>