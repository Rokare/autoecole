<?php

//insert.php

$connect = new PDO('mysql:host=localhost;dbname=adlauto', 'root', '');
if(isset($_POST["title"]))
{

    $req ="select * from moniteur where nom =:nom";
    $requete = $connect->prepare($req);
    $requete->execute(
      array(
       ':nom' => $_POST['moniteur']
    ));
    $rep=$requete->fetch();
    $mat_m = $rep['matricule'];



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
            if($_POST['end'] == $rep2['start_event'] || $_POST['start'] == $rep2['end_event'])
            {
              $nb --;
            }
          }

    if($nb == 0 && !empty($mat_m))
    {
           $query = "
           INSERT INTO events2
           (title, start_event, end_event, matricule, mat_m)
           VALUES (:title, :start_event, :end_event, :matricule, :mat_m)
           ";
           $statement = $connect->prepare($query);

          if($statement->execute(
            array(
             ':title'  => $_POST['title'],
             ':start_event' => $_POST['start'],
             ':end_event' => $_POST['end'],
             ':matricule' => $_POST['matricule'],
             ':mat_m' => $mat_m
            )
           ))
           {
            echo 'ezeaz';

           }
           else {
             echo $statement->errorCode();
             echo 'erreur';
             header('Location:iii.php');

           }

    }
    if(empty($mat_m) || $nb > 0)
    {
      echo "<script language='javascript'>document.location='index.php'; </script>";
           header('Location:iii.php');
    }

}


?>
