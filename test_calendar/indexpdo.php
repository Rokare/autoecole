<?php
session_start();


include("dbconn.php");
$connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
if(!isset($_SESSION['user']))
{
    $_SESSION['user'] = session_id();
	
}
else
{
	echo 'dqd';
}
$uid = $_SESSION['user'];  // set your user id settings
$datetime_string = date('c',time());

if(isset($_POST['action']) or isset($_GET['view']))
{
    if(isset($_GET['view']))
    {
        header('Content-Type: application/json');
        $start = "2018-04-23";
        $end = "2018-04-23";

       /*$result =$connection->prepare("SELECT `id`, `start` ,`end` ,`title` FROM  `events` where (date(start) >= :start AND date(start) <= :end) and uid=':uid'");
		$result->bindValue(":uid",$uid,PDO::PARAM_STR);
    	$result->bindValue(":end",$end,PDO::PARAM_STR);
    	$result->bindValue(":start",$start,PDO::PARAM_STR);
		$result->execute();*/
		 $result = $connection->query("SELECT `id`, `start` ,`end` ,`title` FROM  `events` where uid='j6svf047q4tj4f6tn37vett7h2'");
		
       while($row = $result->fetch(PDO::FETCH_ASSOC))
        {
            $events[] = $row;
        }
		
		
        echo json_encode($events);
        
    }
    elseif($_POST['action'] == "add")
    {
        $connection->query("INSERT INTO `events` (
                    `title` ,
                    `start` ,
                    `end` ,
                    `uid`
                    )
                    VALUES (
                    '".$_POST["title"]."',
                    '".date('Y-m-d H:i:s',strtotime($_POST["start"]))."',
                    '".date('Y-m-d H:i:s',strtotime($_POST["end"]))."',
                    '".$uid."'
                    )");
        header('Content-Type: application/json');
        echo '{"id":"'.$connection->lastInsertId().'"}';
        exit;
    }
    elseif($_POST['action'] == "update")
    {
        $connection->query("UPDATE `events` set
            `start` = '".date('Y-m-d H:i:s',strtotime($_POST["start"]))."',
            `end` = '".date('Y-m-d H:i:s',strtotime($_POST["end"]))."'
            where uid = '".$uid."' and id = '".$_POST["id"]."'");
        exit;
    }
    elseif($_POST['action'] == "delete")
    {
        $connection->query("DELETE from `events` where uid = '".$uid."' and id = '".$_POST["id"]."'");
        if ($connection->rowCount() > 0) {
            echo "1";
        }
        exit;
    }
}

?>

<!doctype html>
<html lang="Fr"><head>
    <title>jQuery Fullcalendar Integration with Bootstrap, PHP & MySQL | PHPLift.net</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <style type="text/css">

      img {border-width: 0}
      * {font-family:'Lucida Grande', sans-serif;}
    </style>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script type="text/javascript" src="js/script.js"></script>

    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" crossorigin="anonymous"></script>
    <link  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" >
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/fullcalendar.css" rel="stylesheet" />
    <link href="css/fullcalendar.print.css" rel="stylesheet" media="print" />
    <script src="js/moment.min.js"></script>
    <script src="js/fullcalendar.js"></script>


  </head>
  <body  >
<!-- add calander in this div -->

<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a id="brand" class="navbar-brand" href="../index.html">Auto Ecole Castellane</a>
      </div>

      <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav navbar-right">

          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
      <span class="glyphicon glyphicon-user"></span><span class="caret"></span></a>
            <ul class="dropdown-menu">
              <li><a href="../php/logout.php?logout"><span class="glyphicon glyphicon-log-out"></span>&nbsp;Se déconnecter</a></li>
              <li><a href="../php/home.php">Retour vers mon portail</a></li>
            </ul>
          </li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </nav>

<div id="calendrier" class="container">
  <div class="row">
<div id="calendar"></div>

</div>
</div>


<!-- Modal -->
<div id="createEventModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Ajouter Heure de conduite</h4>
      </div>
      <div class="modal-body">
            <div class="control-group">
                <label class="control-label" for="inputPatient">Nom:</label>
                <div class="field desc">
                    <input class="form-control" id="title" name="title" placeholder="Event" type="text" value="">
                </div>
            </div>

            <input type="hidden" id="startTime"/>
            <input type="hidden" id="endTime"/>



        <div class="control-group">
            <label class="control-label" for="when">Horaire:</label>
            <div class="controls controls-row" id="when" style="margin-top:5px;">
            </div>
        </div>

      </div>
      <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">Annuler</button>
        <button type="submit" class="btn btn-primary" id="submitButton">Enregistrer</button>
    </div>
    </div>

  </div>
</div>


<div id="calendarModal" class="modal fade">
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Détail Heure de conduite</h4>
        </div>
        <div id="modalBody" class="modal-body">
        <h4 id="modalTitle" class="modal-title"></h4>
        <div id="modalWhen" style="margin-top:5px;"></div>
        </div>
        <input type="hidden" id="eventID"/>
        <div class="modal-footer">
            <button class="btn" data-dismiss="modal" aria-hidden="true">Annuler</button>
            <button type="submit" class="btn btn-danger" id="deleteButton">Supprimer</button>
        </div>
    </div>
</div>
</div>
<!--Modal-->


<div style='margin-left: auto;margin-right: auto;text-align: center;'>
</div>
  </body>
</html>