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
<form:form method="post" modelAttribute="loginpage">

<p>
<span class="label">User Name </span> <form:input type="text" path="username"  placeholder="Your username"/>
</p>
<p>
	<span class="label">Password </span> <form:input type="password" path="password"  placeholder=""/>
</p>
<div class="btn-group">
<button class="btn">Register</button>
</form:form>
</body>
</html>