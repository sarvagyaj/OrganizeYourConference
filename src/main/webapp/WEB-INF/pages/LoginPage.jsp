<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Login Page">
<meta name="author" content="">
<link rel="shortcut icon" href="../../assets/ico/favicon.png">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/carousel.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">

<title>Login page</title>
<style type="text/css">
.loginDiv { min-height:0px;padding-left:150px;padding-bottom:20px;background-color:black;color:white}
.boxCloser {background-image: url("images/closewhite.png");
				background-repeat:no-repeat;
				position:absolute;
				right:60px;
				top:18px;
				height: 24px;
				padding: 0 13px;
				cursor:pointer;}
.error {
	color: #ff0000;
}
.errorcss{
	color: #000;
	background-color: #ffEEEE;
}
</style>
</head>

<body id="LoginPage" >
<form:form method="POST" commandName="loginpage">
	
<div class="loginDiv" style="display:none">
	<div class="loginLabel">Log in <a style="font: 12px helvetica,arial,sans-serif;" href="SignUp">Need an Account?</a> 
	<span id="oyc-login-signup-close" class="boxCloser">&nbsp;</span>
	</div>	
	<div id="oyc_login_form">
		<form:input class="form-signin" path="emailId" id="oyc_email" type="text" placeholder="email"></form:input>
		<form:errors id="email_error" path="emailId" cssClass="error" />		
		<form:input class="form-signin" id="oyc_pass" path="password" name="oyc_name_pass" placeholder="password" type="password" autocomplete="off"></form:input>
		<form:errors id="password_error" path="password" cssClass="error" />
		<button id="oyc_login_btn" class="btn btn-small btn-primary" style="float:none" type="submit">Log In</button>  
		<!--<input id="oyc_login_btn" class="btn btn-small btn-primary" style="float:none" type="submit" ></input>-->
		</br>
		<label for="type">User Type: </label>
        <form:radiobutton path="role" value="Organizer" />Organizer
		<form:radiobutton path="role" value="Speaker" />Speaker
		<form:radiobutton path="role" value="Participant" />Participant
	</div>
	
</div>

 <div class ="navbar-wrapper">
      <div class ="navbar navbar-inverse navbar-static-top">
        <div class ="container">
          <div class ="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Organize your Conference</a>
          </div>
          <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Home</a></li>
              <li id="oyc_login"><a href="#">Log In</a></li>
            </ul>
          </div>
        </div>
      </div>
</div>


<div id="myCarousel" class="carousel slide" height="200">
	<ol class="carousel-indicators">		
	        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	        <li data-target="#myCarousel" data-slide-to="1"></li>
	        <li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>
	<div class="carousel-inner">
	<div class="item active">
		<div class="container">
	            <div class="carousel-caption" height="200px">
	              <h1>Want to Host a conference</h1>
	              <p>Organize all your conference with us for free</p> 
	              <p><a class="btn btn-large btn-primary" id="p1_login">Login Now</a></p>
		</div>
		</div>
	</div>
	<div class="item">
			<div class="container">
            <div class="carousel-caption" height="200px">
              <h1>>Want to attend a Conference???</h1>
              <p>Choose a Conference of your best interest and Register with us today to attend it and get great benefits out of it!!</p> 
              <p><a class="btn btn-large btn-primary" id="p2_login">Login Now</a></p>
            </div>
            </div>
	</div>
	<div class="item">
		<div class="container">
	            <div class="carousel-caption" height="200px">
	              <h1>Organize you conference on Cloud!!</h1>
	              <p>All the materials of the organized conference on Secure Cloud for all time access.</p> 
	              <p><a class="btn btn-large btn-primary" id="p3_login">Login Now</a></p>
	     </div>
	</div>
	</div>
<a class="left carousel-control" href="#myCarousel" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
<a class="right carousel-control" href="#myCarousel" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
	</div>

<div class="container marketing">

     
      <div class="row">
        <div class="col-lg-4">
          
          <h2>Introduction to Finance</h2>
          <p>This course will introduce you to frameworks and tools to measure value; both for corporate and personal assets. It will also help you in decision-making, again at both the corporate and personal levels.</p>
          <p><a class="btn btn-default btn-primary" id="p4_login">Register &raquo;</a></p>
        </div>
        <div class="col-lg-4">
          <h2>Model Thinking</h2>
          <p>In this class, you will learn how to think with models and use them to make sense of the complex world around us.</p>
          <p><a class="btn btn-default btn-primary" id="p5_login">Register &raquo;</a></p>
        </div>
        <div class="col-lg-4">
          
          <h2>Big Data in Education</h2>
          <p>Education is increasingly occurring online or in educational software, resulting in an explosion of data that can be used to improve educational effectiveness and support basic research on learning. In this course, you will learn how and when to use key methods for educational data mining and learning analytics on this data.</p>
          <p><a class="btn btn-default  btn-primary" id="p6_login">Register &raquo;</a></p>
        </div>
      </div>
 
      <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; Edu SJSU. &middot;</p>
      </footer>

</div>
</div>
<script src="//code.jquery.com/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/carousel.js"></script>
<script src="js/app.js"></script>
<script src="js/holder.js"></script>
</form:form>
</body>
</html>
