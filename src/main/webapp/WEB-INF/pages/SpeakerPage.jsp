<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
<!DOCTYPE html>   
<html lang="en">   
<head>   
<meta charset="utf-8">   
<title>Speaker Page</title>   
<meta name="description" content="Guest Page">  
<link href="css/bootstrap.css" rel="stylesheet"> 
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
background-color:#b0c4de;
margin-top:50px;
margin-bottom:100px;
margin-right:50px;
margin-left:50px;
}
</style>
</head> 
 
<body>  
<div class="offset5">
<h3><b><font color = "3333CC" face="Eras Demi ITC">Guest Speaker Profile</font></b></h3></div>
<div class="span3">  
<div class="offset2">
<form:form method="post" modelAttribute="speaker">
<p>
	<span class="label">First Name </span> <form:input type="text" path="firstName"  placeholder="Your First Name"/>
</p>
<p>
	<span class="label">Last Name </span> <form:input type="text" path="lastName"  placeholder="Your last Name"/>
</p>
<p>
	<span class="label">Email ID</span> <form:input type="email" path="emailId" placeholder="Your Email ID"/>
</p>
<p>
	<span class="label">Location</span> <form:input type="text" path="location" placeholder="Your Location"/>
</p>
<p>
	<span class="label">Role</span> <form:input type="text" path="role" placeholder="Your Role in Company"/>
</p>
			
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