<?php

?>

    <div class="col-md-6">
 <table class="table table-sm table-dark">
  <thead>
    <tr>
      <th scope="col">Nom</th>
      <th scope="col">Prénom</th>
      <th scope="col">E-mail</th>
      <th scope="col">Login</th>
      <th scope="col">Téléphone</th>
      <th scope="col">Ville</th>
      <th scope="col"></th>


    </tr>
  </thead>
  <?php
  if(isset($resultat))
  {
     foreach($resultat as $resultats) {


    echo "
    <tr><td>".$resultats['nom']."</td>

            <td>".$resultats['prenom']."</td>
            <td>".$resultats['email']."</td>
            <td>".$resultats['login']."</td>
            <td>".$resultats['telephone']."</td>
            <td>".$resultats['id_ville']."</td>
            <td><a href ='indexTiers.php?suppr'  type='button' class='btn btn-danger'>Supprimer</a></td>
            <td><a href = ''  type='button' class='btn btn-info'>Modifier</a></td>


            </tr/>
            ";

            if(isset($_GET['suppr']))
            {
              $_SESSION['suppr'] = $resultats['matricule'];
            }


  }
}
   ?>
</table>
    </div>
</div>


