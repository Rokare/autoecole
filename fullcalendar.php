<!DOCTYPE html>
<html>
 <head>
  <title>Jquery Fullcalandar Integration with PHP and Mysql</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.4.0/fullcalendar.css" />
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/css/bootstrap.css" />
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/fullcalendar/3.4.0/fullcalendar.min.js"></script>
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
    editable:true,
    header:{
     left:'prev,next today',
     center:'title',
     right:'month,agendaWeek,agendaDay'
    },
    events: './Controleur/fullcalendar/load.php?matricule='+$_GET('matricule'),
    selectable:true,
    selectHelper:true,
    select: function(start, end, allDay, matricule)
    {
     var title = prompt("Entrer Titre");
     var moniteur = prompt('Entrer moniteur')
     if(title && moniteur)
     {
      var start = $.fullCalendar.formatDate(start, "Y-MM-DD HH:mm:ss");
      var end = $.fullCalendar.formatDate(end, "Y-MM-DD HH:mm:ss");

      var matricule = $_GET('matricule');
      $.ajax({
       url:"./Controleur/fullcalendar/insert.php",
       type:"POST",
       data:{title:title, start:start, end:end,matricule:matricule, moniteur:moniteur},
       success:function()
       {
        calendar.fullCalendar('refetchEvents');
        alert("Ajout");
      },
       error: function(xhr, status, error) {
         alert('sqdsqdqdq');
        alert("An AJAX error occured: " + status + "\nError: " + error);
        }
      })
     }
    },
    editable:true,
    eventResize:function(event)
    {
     var start = $.fullCalendar.formatDate(event.start, "Y-MM-DD HH:mm:ss");
     var end = $.fullCalendar.formatDate(event.end, "Y-MM-DD HH:mm:ss");
     var title = event.title;
     var id = event.id;
     $.ajax({
      url:"./Controleur/fullcalendar/update.php",
      type:"POST",
      data:{title:title, start:start, end:end, id:id},
      success:function(){
       calendar.fullCalendar('refetchEvents');
       alert('Event Update');
      }
     })
    },

    eventDrop:function(event)
    {
     var start = $.fullCalendar.formatDate(event.start, "Y-MM-DD HH:mm:ss");
     var end = $.fullCalendar.formatDate(event.end, "Y-MM-DD HH:mm:ss");
     var title = event.title;
     var id = event.id;
     $.ajax({
      url:"./Controleur/fullcalendar/update.php",
      type:"POST",
      data:{title:title, start:start, end:end, id:id},
      success:function()
      {
       calendar.fullCalendar('refetchEvents');
       alert("évenement mis à jour");
      }
     });
    },

    eventClick:function(event)
    {
     if(confirm("Etes"))
     {
      var id = event.id;
      $.ajax({
       url:"./Controleur/fullcalendar/delete.php",
       type:"POST",
       data:{id:id},
       success:function()
       {
        calendar.fullCalendar('refetchEvents');
        alert("Evenement supprimé");
       }
      })
     }
    },

   });
  });

  </script>
 </head>
 <body>
  <br />
  <h2 align="center"><a href="#">Jquery Fullcalandar Integration with PHP and Mysql</a></h2>
  <br />
  <div class="container">
   <div id="calendar"></div>
  </div>
 </body>
</html>
