<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Participant Page</title>
<meta name="description" content="Participant Page">
<!-- <link href="css/ParticipantSpeaker.css" rel="stylesheet">
<link href="css/header.css" rel="stylesheet"> -->

<link href="css/bootstrap.css" rel="stylesheet">
<script src="jquery-2.0.3.js"></script>

<style>
 body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }

      @media (max-width: 980px) {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right {
          float: none;
          padding-left: 5px;
          padding-right: 5px;
        }
      }

</style>
<link href="http://getbootstrap.com/2.3.2/assets/css/bootstrap-responsive.css" rel="stylesheet"> 
</head>
<body>
		
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="brand" href="#">Project name</a>
          <div class="nav-collapse collapse">
            <p class="navbar-text pull-right">
              Logged in as <a href="#" class="navbar-link">Username</a>
            </p>
            <ul class="nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">Sidebar</li>
              <li class="active"><a href="#">Link</a></li>
              <li><a href="LoginPage">Click</a></li>
              <li><a href="#">Link</a></li>
              <li><a href="#">Link</a></li>
              <li class="nav-header">Sidebar</li>
              <li><a href="#">Link</a></li>
              <li><a href="#">Link</a></li>
              <li><a href="#">Link</a></li>
             </ul>
          </div><!--/.well -->
        </div><!--/span-->
	
	
	<div class="offset4">
		<h3>
			<b><font color="336600" face="Eras Demi ITC">Register for
					Conference</font></b>
		</h3>
	</div>
	<div class="row">
		<div class="span3">
			<div class="offset3">

				<form:form method="post" modelAttribute="participant">
					<p>
						<span class="label">First Name </span>
					</p>
					<form:input type="text" path="firstName"
						placeholder="Your First Name" />
					<p>
						<span class="label">Last Name </span>
					</p>
					<form:input type="text" path="lastName"
						placeholder="Your last Name" />

					<p>
						<span class="label">Email ID</span>
					</p>
					<form:input type="email" path="emailId" placeholder="Your Email ID" />

					<p>
						<span class="label">Location</span>
					</p>
					<form:input type="text" path="location" placeholder="Your Location" />
					<br>
					<br>
					<div>
						<button class="btn-large">Conference Registration</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>