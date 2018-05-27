<?php

//insert.php

$connect = new PDO('mysql:host=localhost;dbname=adlauto', 'root', '');
$mat = $_GET['matricule'];
if(isset($_POST["title"]))
{

$req ="select matricule from tiers where nom=:moniteur";

$req2 ="select count(*) from events2 where mat_m=:moniteur and start_event >= :start_envent and end_event <= :end_event";

 $query = "
 INSERT INTO events2
 (title, start_event, end_event, matricule)
 VALUES (:title, :start_event, :end_event, :matricule)
 ";
 $statement = $connect->prepare($query);
$statement->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
if($statement->execute(
  array(
   ':title'  => $_POST['title'],
   ':start_event' => $_POST['start'],
   ':end_event' => $_POST['end'],
   ':matricule' => $_POST['matricule']
  )
 ))
 {
   echo 'insertion';
 }
 else {
   echo $statement->errorCode();
   echo 'erreur';
   header('Location:iii.php');
 }
}


?>
