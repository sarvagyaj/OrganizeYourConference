<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="edu.sjsu.conference.index"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orgainse Your Conference</title>
<script type="text/javascript">
	function homeonload()
	{
		alert('H');
		var te =edu.sjsu.conference.index.getsome();
		alert('L');
		document.getElementById("tes1").value = te;
		alert('M');
		
	}
</script>
</head>
<body onload=homeonload()>
<form id="home">
<span id="test">Hi</span>
<input id="tes1" type="text" value="Hi" />
<input id="btn1" type="button" onkeypress="homeonload()" />
<a href="LoginPage.jsp">link</a>
</form>
</body>
</html>