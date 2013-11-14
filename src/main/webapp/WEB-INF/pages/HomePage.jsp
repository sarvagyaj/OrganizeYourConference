<!DOCTYPE html>
<html lang="en">
  <head>
  
    <meta charset="utf-8">
    <title>Bootstrap, from Twitter</title>
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

  <body style="background-color:#E6FCB9;">
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">	
          <a class="navbar-brand" style="color:white;font-size:30px;font-style:italic;" href="#">Organize Your Conference</a>
          <p align="right" class="navbar-brand navbar-pull-right">Logged in as <a class="navbar-brand navbar-pull-right" href="#">${UserName}</a></p> 
        </div>
      </div>
    </div>
	
    <div class="container-fluid" >
     <div class="row-fluid">
        <div class="span2">
          <div class="well sidebar-nav" height="90%">
            <ul class="nav nav-list">
              <li ><a class="nav-header" href="#">Home</a></li>
              <li class="nav-header"> Profile</li>
              <li><a class="nav-list" href="ProfilePage">View/Edit Profile</a></li>
              <li class="nav-header">Conference</li>
              <li><a class="nav-list" href="NewConference">Create Conference</a></li>
              <li><a class="nav-list" href="ViewAllPreviousConference">Previous Conferences</a></li>
              <li><a class="nav-list" href="RegisterParticipant">Register for Conferences</a></li>
            </ul>
          </div><!--/.well -->
        </div><!--/span-->	 
	<form id="ViewConference">
        <div class="span9">
          <div class="hero-unit">
            <h1>Hello, world!</h1>
            <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
            <p><a href="#" class="btn btn-primary btn-large">Learn more &raquo;</a></p>
          </div>
          <div class="hero-unit">
            <h1>Hello, world!</h1>
            <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
            <p><a href="#" class="btn btn-primary btn-large">Learn more &raquo;</a></p>
          </div>
          <div class="hero-unit">         
            <h1>Hello, world!</h1>
            <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
            <p><a href="#" class="btn btn-primary btn-large">Learn more &raquo;</a></p>         
          </div>
          <div class="hero-unit">
            <h1>Hello, world!</h1>
            <p>This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
            <p><a href="#" class="btn btn-primary btn-large">Learn more &raquo;</a></p>
          </div>                  
        </div><!--/span-->      
	  </form>
	   </div><!--/row-->
	    
      <hr>

      <footer>
        <p>&copy;SJSU Edu</p>
      </footer>

    </div>
    <script src="js/jquery.js"></script>

  </body>
</html>
