<?php

//update.php

$connect = new PDO('mysql:host=localhost;dbname=adlauto', 'root', '');

$start = '2018-05-28 08:00:00';
$end = '2018-05-28 12:00:00';
$mat_m = '8584785';
$id_event = 97;

    $req2 ="SELECT count(*) as nb, id
    FROM events2
    WHERE mat_m=:moniteur
    AND start_event BETWEEN :start_event and :end_event
    OR end_event BETWEEN :start_event and :end_event;";

    $requete2 = $connect->prepare($req2);
    $requete2->execute(array(
       ':start_event' => $start,
       ':end_event' => $end,
       ':moniteur' => $mat_m
      ));

    $req3 ="SELECT count(*) as nb, id
    FROM events2
    WHERE mat_m=:moniteur
    AND start_event BETWEEN :start_event and :end_event
    AND end_event BETWEEN :start_event and :end_event;";

    $requete3 = $connect->prepare($req3);
    $requete3->execute(array(
       ':start_event' => $start,
       ':end_event' => $end,
       ':moniteur' => $mat_m
      ));
    $rep2=$requete2->fetch();
    $rep3=$requete3->fetch();
      $nb=$rep2['nb'];
      $nb2 = $rep3['nb'];
      $id = $rep2['id'];
      if($rep2['id'] == $id_event || $rep3['id'] == $id_event)
      {
        $nb --;

      }

    echo $nb;
    echo $id."<br>";
    echo $nb2;
    echo $rep3['id'];
/*
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
*/

?>
