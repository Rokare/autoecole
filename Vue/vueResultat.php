<?php

?>

    <div class="col-md-3 col-md-pull-9">
 <table class="table table-sm table-dark">
  <thead>
    <tr>
      <th scope="col">Nom</th>
      <th scope="col">Prénom</th>
      <th scope="col">E-mail</th>
      <th scope="col">Login</th>
      <th scope="col">Adresse</th>
      <th scope="col">Téléphone</th>
      <th scope="col">Ville</th>
      <th scope="col">Date d'inscription</th>
      <th scope="col">Mode de facturation</th>
      <th scope="col"></th>


    </tr>
  </thead>
  <?php
  if(isset($resultat))
  {
     foreach($resultat as $resultats) {



<<<<<<< HEAD

    echo "
    <tr><td>".$resultats['nom']."</td>

=======
>>>>>>> 03c10fdbb24af72f455b3a966e4a79a505ae24e5
    echo "<tr><td>".$resultats['nom']."</td>

            <td>".$resultats['prenom']."</td>
            <td>".$resultats['email']."</td>
            <td>".$resultats['login']."</td>
            <td>".$resultats['adresse']."</td>
            <td>".$resultats['telephone']."</td>
            <td>".$resultats['id_ville']."</td>
            <td>".$resultats['date_i']."</td>
            <td>".$resultats['mode_fact']."</td>
            <td><a href ='indexTiers.php?suppr'  type='button' class='btn btn-danger'>Supprimer</a></td>
            <td><a href = ''  type='button' class='btn btn-info'>Modifier</a></td>

<<<<<<< HEAD
            </tr/>
            ";

=======
>>>>>>> 03c10fdbb24af72f455b3a966e4a79a505ae24e5
            </tr/>";
            if(isset($_GET['suppr']))
            {
              $_SESSION['suppr'] = $resultats['matricule'];
            }


  }
}
   ?>
</table>
    </div>
<<<<<<< HEAD


=======
</div>
>>>>>>> 03c10fdbb24af72f455b3a966e4a79a505ae24e5
