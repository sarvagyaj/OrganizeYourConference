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
<form:form method="post" modelAttribute="loginpage" class="form-signin">
<h1><font color="#336600" face="Eras Demi ITC"><span>
Login Please!! 
</span></font></h1>
</br>
</br>
</br>
</br>
<!-- <p>
	<span>User Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <form:input type="text" path="username"  placeholder="Your username"/>
</p>
<p>
	<span>Password&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span> <form:input type="password" path="password"  placeholder="Password"/>
</p>
<p>
	<span><form:radiobutton path="type" value="Organizer"/>Organizer 
		  <form:radiobutton path="type" value="Participant"/>Participant
		  <form:radiobutton path="type" value="Speaker"/>Speaker</span>
</p>
<p>
	<span>Remember Me </span> <form:input type="checkbox" path="password"  placeholder=""/>
</p>

<button class="btnsign">Register</button></a>
 -->
 <p>Click <a href="NewConference">here</a> if you are Organizer </p>
 <p>Click <a href="https://www.linkedin.com/uas/oauth2/authorization?response_type=code&scope=r_fullprofile%20r_emailaddress%20&client_id=9xb4aca5h8ka&state=12345&redirect_uri=http://localhost:8080/organize-your-conference/linkedin">
 here</a> if you are Speaker </p>
 <p>Click <a href="registerParticipant">here</a> if you are Participant </p>
</form:form>
</body>
</html>