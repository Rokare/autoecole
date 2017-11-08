
<br/><h2> Liste des eleves de l'ecole iris</h2><br>
<table border=1>
    <tr><td> Nom</td> <td>Prenom</td>
    <td>Classe</td><td>Age</td></tr>
<?php




    foreach($resultats as $unResultat)
    {
        echo "<tr><td>".$unResultat['nom']."</td>";
        echo "<td>".$unResultat['prenom']."</td>";
        echo "<td>".$unResultat['classe']."</td>";
        echo "<td>".$unResultat['age']."</td></tr>";
    }


?>
</table>
  