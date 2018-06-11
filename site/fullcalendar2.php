<?php session_start(); ?>
<!DOCTYPE html>
<html>
 <head>
  <title>Jquery Fullcalandar Integration with PHP and Mysql</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.4.0/fullcalendar.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.css" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
    <link href="Vue/bootstrap-4.0.0-beta.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src=".\Controleur\fullcalendar\js\moment.min.js"></script>
  <script src=".\Controleur\fullcalendar\js\fullcalendar.min.js"></script>
  <script src=".\Controleur\fullcalendar\js\locale-all.js"></script>
  <script>


  function $_GET(param) {
  	var vars = {};
  	window.location.href.replace( location.hash, '' ).replace(
  		/[?&]+([^=&]+)=?([^&]*)?/gi, // regexp
  		function( m, key, value ) { // callback
  			vars[key] = value !== undefined ? value : '';
  		}
  	);

  	if ( param ) {
  		return vars[param] ? vars[param] : null;
  	}
  	return vars;
  }


  $(document).ready(function() {
   var calendar = $('#calendar').fullCalendar({
     locale:'fr',
    lang: 'fr',

    header:{
     left:'prev,next today',
     center:'title',
     right:'month,agendaWeek,agendaDay'
    },
    events: './Controleur/fullcalendar/load2.php?matricule='+$_GET('matricule'),

    selectHelper:true,






   });
  });

  </script>
     <?php include "./Vue/vueNavBarCandidat.php"; ?>
 </head>
 <body>
  <br />
  <h2 align="center"><a href="#">Planning Moniteur</a></h2>
  <br />
  <div class="container">
   <div id="calendar"></div>
  </div>
 </body>
</html>
