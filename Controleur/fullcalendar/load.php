<?php

//load.php

$connect = new PDO('mysql:host=localhost;dbname=adlauto', 'root', '');

$data = array();

$query = "SELECT * FROM events2 where matricule = :matricule ORDER BY id";

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
 $data[] = array(
  'id'   => $row["id"],
  'title'   => $row["title"],
  'start'   => $row["start_event"],
  'end'   => $row["end_event"]

 );
}

echo json_encode($data);

?>
