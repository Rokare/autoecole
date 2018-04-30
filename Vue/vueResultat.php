<?php

?>
 <table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">Nom</th>
      <th scope="col">Prénom</th>
      <th scope="col">E-mail</th>
      <th scope="col">Login</th>
    </tr>
  </thead>
  <?php
     foreach($resultat as $resultats) {




    echo "<tr><td>".$resultats['nom']."</td>
            <td>".$resultats['prenom']."</td>
            <td>".$resultats['email']."</td>
            <td>".$resultats['login']."</td>

            </tr/>";
  }
   ?>
</table>
