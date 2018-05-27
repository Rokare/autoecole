<?php

//update.php

$connect = new PDO('mysql:host=localhost;dbname=adlauto', 'root', '');



  $req ="select * from events2 where id =:id";
  $requete = $connect->prepare($req);
  $requete->execute(
    array(
     ':id' => $_POST['id']
  ));
  $rep=$requete->fetch();
  $mat_m = $rep['mat_m'];

$mat_m = '8584785';

  $req2 ="SELECT count(*) as nb
  FROM events2
  WHERE mat_m=:moniteur
  AND start_event not BETWEEN :start_event and :end_event
  OR end_event not BETWEEN :start_event and :end_event;";
  $requete2 = $connect->prepare($req2);
  $requete2->execute(array(
     ':start_event' => $_POST['start'],
     ':end_event' => $_POST['end'],
     ':moniteur' => $mat_m
    ));

  if($rep2=$requete2->fetch())
  {
    $nb = $rep2['nb'];
  }

  if($nb == 0 )
  {
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


   if( $nb > 0)
   {
     echo "<script language='javascript'>document.location='index.php'; </script>";
          header('Location:iii.php');
   }


?>
