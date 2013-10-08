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
<div class="row">  
<div class="span9">  
<p><span class="label">First Name </span>
<input type="text" class="span3" placeholder="Your First Name"></p>
<p><span class="label">Last Name </span>
<input type="text" class="span3" placeholder="Your Last Name"></p>
<p><span class="label">Email ID</span>
 <input type="text" class="span3" placeholder="Your Email ID"></p> 
<p><span class="label">Address</span>
<input type="text" class="span3" placeholder="Your Address"></p> 
</div>  
</div>
<div class="btn-group"> <a href="index.jsp"><button class="btn"> Conference Registration </button></a> </div>
</body>  
</html>