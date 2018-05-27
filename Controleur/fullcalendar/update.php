<?php

//update.php

$connect = new PDO('mysql:host=localhost;dbname=adlauto', 'root', '');

if(isset($_POST["id"]))
{


  $req ="select * from moniteur where nom =:nom";
  $requete = $connect->prepare($req);
  $requete->execute(
    array(
     ':nom' => $_POST['moniteur']
  ));
  $rep=$requete->fetch();
  $mat_m = $rep['matricule'];



  $req2 ="select count(*) as nb from events2 where mat_m=:moniteur and start_event >= :start_event and end_event <= :end_event";
  $requete2 = $connect->prepare($req2);
  $requete->execute(array(
     ':start_event' => $_POST['start'],
     ':end_event' => $_POST['end'],
     ':moniteur' => $mat_m
    ));

  if($rep2=$requete2->fetch())
  {
    $nb = $rep2['nb'];
  }



     $query = "
     UPDATE events2
     SET title=:title, start_event=:start_event, end_event=:end_event
     WHERE id=:id
     ";
     $statement = $connect->prepare($query);
     $statement->execute(
      array(
       ':title'  => $_POST['title'],
       ':start_event' => $_POST['start'],
       ':end_event' => $_POST['end'],
       ':id'   => $_POST['id']
      )
     );
}

?>
