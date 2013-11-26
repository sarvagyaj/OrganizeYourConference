<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="description" content="Login Page">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
<title>Login page</title>
</head>
<script type="text/javascript">
	
</script>
<body>
<form:form method="post" modelAttribute="login" class="form-signin">
<h1><font color="#336600" face="Eras Demi ITC"><span>
Login Please!! 
</span></font></h1>
<p>
	<span class="label">Username </span> </p>
	<form:input type="text" path="emailId"  placeholder="Your First Name"/>

<p>
	<span class="label">Password </span> </p>
	<form:input type="password" path="password"  placeholder="Your last Name"/>

<p>
	<span class="label">Role</span></p>
	 <form:input type="text" path="role" placeholder="Your Email ID"/>

<p>
<div class="btn-group">
				<button class="btn">Sign In</button>
			</div>

 <p>Click <a href="NewConference">here</a> if you are Organizer </p>

 <p>Click <a href="registerParticipant">here</a> if you are Participant </p>
</form:form>
</body>
</html>
