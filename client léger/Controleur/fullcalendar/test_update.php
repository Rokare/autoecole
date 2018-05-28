<?php

//update.php

$connect = new PDO('mysql:host=localhost;dbname=adlauto', 'root', '');

$start = '2018-05-28 02:00:00';
$end = '2018-05-28 03:00:00';
$mat_m = '8584785';
  $req ="select * from events2 where mat_m =:mat_m";
  $requete = $connect->prepare($req);
  $requete->execute(
    array(
     ':mat_m' => $mat_m
  ));
  $nb = 0;
while($rep=$requete->fetch())
{
  if(strtotime($start) <= strtotime($rep['start_event']) && strtotime($end) >= strtotime($rep['end_event']))
  {
      $nb++;
      $id = $rep['id'];
      if($rep['id'] == $id_event)
      {
        $nb--;
      }
  }



}
echo  $nb;
echo $id;

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
