<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>   
<html lang="en">   
<head>   
<meta charset="utf-8">   
<title>Participant Page</title>   
<meta name="description" content="Participant Page">  
<link href="css/bootstrap.css" rel="stylesheet"> 
<script src="jquery-2.0.3.js"></script> 
<script>
$(function(){
$('#conference').on('click', function (e) {
	
  alert('Hello!');
 });
});

</script>
</head> 

<body>  

<div class="offset5">
<h3>Register for Conference</h3></div>
<div class="row">  
<div class="span3">
<div class="offset2">

<p><span class="label">First Name </span></p>
<input type="text" class="span3" placeholder="Your First Name">
<p><span class="label">Last Name </span></p>
<input type="text" class="span3" placeholder="Your Last Name"> 
<p><span class="label">Email ID</span></p>
<input type="text" class="span3" placeholder="Your Email ID">
<p><span class="label">Address</span></p>
<p><input type="text" class="span3" placeholder="Your Address"> </p>
<div class="btn-group">
<a href="index.jsp"><button class="btn"> Conference Registration </button></a>
</div>
</div>
</div>
</div>

</body>  
</html>