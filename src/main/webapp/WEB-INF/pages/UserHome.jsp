<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
  
    <meta charset="utf-8">
    <title>Home Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

 
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/ParticipantSpeaker.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
      
      .sidebar-nav {
        padding: 9px 0;
      }
      
	
	 .navbar-pull-right {
	 	  float:none;
          padding-left: 10px;
          padding-right: 40px;
        }
    </style>    
  </head>

  <body style="background-color:#E6FCB9;" id="userhomebody">
  <p style="display:none" id="userrole">${user.role}</p>
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">	
          <a class="navbar-brand" style="color:white;font-size:30px;font-style:italic;" href="#">Organize Your Conference</a>           
           <p align="right" class="navbar-brand navbar-pull-right">Logged in as <a class="navbar-brand navbar-pull-right" href="#">${user.firstName} ${user.lastName}</a>
           
           </p>
           
        </div>
      </div>
    </div>
	
    <div class="container-fluid" >
     <div class="row-fluid">
        <div class="span2">
          <div class="well sidebar-nav" height="90%">
            <ul class="nav nav-list">
              <li ><a class="nav-header" href="UserHome">Home</a></li>
              <li class="nav-header"> Profile</li>
              <li><a class="nav-list" href="ProfilePage">View/Edit Profile</a></li>
              <li class="nav-header">Conference</li>
              <li><a id="creatconference" class="nav-list" href="NewConference">Create Conference</a></li>
              <li><a id="prevconference" class="nav-list" href="ViewAllPreviousConference">Previous Conferences</a></li>
              <li><a id="registeredconference" class="nav-list" href="RegisteredConference">Registered Conferences</a></li>
              </br></br> </br></br> </br></br>
              <li class="nav-header"><a class="nav-list"  style="color:white" id="idlogout" href="Logout">Logout</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->	 
	<form id="ViewConference">
        <div class="span9">
          <div class="hero-unit">
          <c:forEach var="objConf" items="${confer}">
			<h1>${objConf.topic}</h1>
			<p>${objConf.description}</p>
			<p><a class="btn btn-primary btn-large" href="ViewConference/${objConf.id}">View details &raquo;</a></p>						
            </c:forEach>
          </div>
          <!-- <div class="hero-unit">
            <h1></h1>
            <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
            <p><a id="#" href="#" class="btn btn-primary btn-large">Learn more &raquo;</a></p>
          </div>
          <div class="hero-unit">         
            <h1></h1>
            <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
            <p><a href="#" class="btn btn-primary btn-large">Learn more &raquo;</a></p>         
          </div>
          <div class="hero-unit">
            <h1>Hello, world!</h1>
            <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
            <p><a href="#" class="btn btn-primary btn-large">Learn more &raquo;</a></p>
          </div> -->                  
        </div><!--/span-->      
	  </form>
	   </div><!--/row-->
	    
      <hr>

      <footer>
        <p>&copy;SJSU Edu</p>
      </footer>

    </div>
    <script src="//code.jquery.com/jquery.js"></script>
	<script src="js/UserHome.js"></script>
  </body>
</html>
