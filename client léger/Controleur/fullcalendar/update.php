<?php

//update.php

$connect = new PDO('mysql:host=localhost;dbname=adlauto', 'root', '');

if(isset($_POST["id"]))
{


  $req ="select * from events2 where id =:id";
  $requete = $connect->prepare($req);
  $requete->execute(
    array(
     ':id' => $_POST['id']
  ));

  $rep=$requete->fetch();
  $mat_m = $rep['mat_m'];



      $req2 ="SELECT count(*) as nb, id,start_event,end_event
      FROM events2
      WHERE mat_m=:moniteur
      AND start_event BETWEEN :start_event and :end_event
      OR end_event BETWEEN :start_event and :end_event;";
      $requete2 = $connect->prepare($req2);
      $requete2->execute(array(
         ':start_event' => $_POST['start'],
         ':end_event' => $_POST['end'],
         ':moniteur' => $mat_m
        ));
      if($rep2=$requete2->fetch())
      {
        $nb=$rep2['nb'];
      
        if($rep2['id'] == $_POST['id'])
        {
          $nb --;
        }

      }
  if( $nb > 0)
   {
     echo "<script language='javascript'>document.location='index.php'; </script>";
          header('Location:iii.php');
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


}

?>
