<?php

//insert.php

$connect = new PDO('mysql:host=localhost;dbname=adlauto', 'root', '');
if(isset($_POST["title"]))
{


    $req3 ="select * from lecon where intitule =:titre";
    $requete3 = $connect->prepare($req3);
    $requete3->execute(
      array(
       ':titre' => $_POST['titre']
    ));
    $rep3=$requete3->fetch();
    $id_lecon = $rep3['id_lecon'];


    $req ="select * from moniteur where nom =:nom";
    $requete = $connect->prepare($req);
    $requete->execute(
      array(
       ':nom' => $_POST['moniteur']
    ));
    $rep=$requete->fetch();
    $mat_m = $rep['matricule'];



          $req2 ="SELECT count(*) as nb,dhd,dhf
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
          }


    if($nb == 0 && !empty($mat_m))
    {
           $query = "
           INSERT INTO planning
           (`dhf`, `id_lecon`, `id_vehicule`, `dhd`, `mat_m`, `mat_c`)
           VALUES (:end_event, :id_lecon, :id_vehicule,:start_event, :mat_m,:mat_c)
           ";
           $statement = $connect->prepare($query);

          if($statement->execute(
            array(
              ':end_event' => $_POST['end'],
              ':id_lecon'  => 1,
              ':id_vehicule' => 2,
               ':start_event' => $_POST['start'],
             ':mat_m' => $mat_m,
             ':mat_c' => $_POST['matricule']
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
