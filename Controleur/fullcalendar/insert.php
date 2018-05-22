<?php

//insert.php

$connect = new PDO('mysql:host=localhost;dbname=adlauto', 'root', '');
$mat = "brebe";
if(isset($_POST["title"]))
{
 $query = "
 INSERT INTO events2
 (title, start_event, end_event, matricule)
 VALUES (:title, :start_event, :end_event, :matricule)
 ";
 $statement = $connect->prepare($query);
 $statement->execute(
  array(
   ':title'  => $_POST['title'],
   ':start_event' => $_POST['start'],
   ':end_event' => $_POST['end'],
   ':matricule' => $mat
  )
 );
}


?>
