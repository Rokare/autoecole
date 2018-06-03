<?php

//update.php

$connect = new PDO('mysql:host=localhost;dbname=adlauto', 'root', '');

if(isset($_POST["id"]))
{


  $req ="select * from planning where id =:id";
  $requete = $connect->prepare($req);
  $requete->execute(
    array(
     ':id' => $_POST['id']
  ));

  $rep=$requete->fetch();
  $mat_m = $rep['mat_m'];



      $req2 ="SELECT count(*) as nb, id,dhd,dhf
      FROM planning
      WHERE mat_m=:moniteur
      AND dhd BETWEEN :start_event and :end_event
      OR dhf BETWEEN :start_event and :end_event;";
      $requete2 = $connect->prepare($req2);
      $requete2->execute(array(
         ':start_event' => $_POST['start'],
         ':end_event' => $_POST['end'],
         ':moniteur' => $mat_m
        ));
      if($rep2=$requete2->fetch())
      {
        $nb=$rep2['nb'];
        if($_POST['end'] == $rep2['dhd'] || $_POST['start'] == $rep2['dhf'])
        {
          $nb --;
        }
        if($rep2['id'] == $_POST['id'] || $_POST['end'] == $rep2['dhd'] || $_POST['start'] == $rep2['dhf'])
        {
          $nb --;
        }

      }
  if( $nb > 0)
   {
          header('Location:iii.php');
   }

  if($nb == 0 )
  {
     $query = "
     UPDATE planning
     SET dhd=:start_event, dhf=:end_event
     WHERE id=:id
     ";
     $statement = $connect->prepare($query);
     $statement->execute(
      array(
       
       ':start_event' => $_POST['start'],
       ':end_event' => $_POST['end'],
       ':id'   => $_POST['id']
      )
     );


   }


}

?>
