<?php

//load.php

$connect = new PDO('mysql:host=localhost;dbname=adlauto', 'root', '');

$data = array();

$query = "SELECT * FROM events2 where mat_m = :mat_m ORDER BY id";

$mat_m = $_GET['matricule'];

$statement = $connect->prepare($query);

$statement->execute(
  array(
   ':mat_m' => $mat_m
  )


);

$result = $statement->fetchAll();

foreach($result as $row)
{
 $data[] = array(
  'id'   => $row["id"],
  'title'   => $row["title"],
  'start'   => $row["start_event"],
  'end'   => $row["end_event"]

 );
}

echo json_encode($data);

?>
