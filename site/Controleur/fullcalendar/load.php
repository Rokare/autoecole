<?php

//load.php

$connect = new PDO('mysql:host=localhost;dbname=adlauto', 'root', '');

$data = array();

$query = "SELECT * FROM planning where mat_c = :matricule order by id";

$mat = $_GET['matricule'];

$statement = $connect->prepare($query);

$statement->execute(
  array(
   ':matricule' => $mat
  )


);

$result = $statement->fetchAll();

foreach($result as $row)
{
  $req = "SELECT * FROM lecon where id_lecon = :id_lecon";
  $requete = $connect->prepare($req);
  $requete->execute(
    array(
     ':id_lecon' => $row['id_lecon']
   ));
   $rep=$requete->fetch();
   $lecon = $rep['intitule'];


   $req2 ="select * from moniteur where matricule =:mat_m";
   $requete2 = $connect->prepare($req2);
   $requete2->execute(
     array(
      ':mat_m' => $row['mat_m']
   ));
   $rep2=$requete2->fetch();
   $moniteur = $rep2['nom'];
 $data[] = array(
   'id'   => $row["id"],
  'title'   => "
  type = ".$lecon."   
  moniteur =".$moniteur,
  'start'   => $row["dhd"],
  'end'   => $row["dhf"]

 );
}

echo json_encode($data);

?>
