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
     foreach ($resultat as $resultats) {
         
     
     ?>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td><?php echo $resultats['nom']?></td>
      <td><?php echo $resultats['prenom']?></td>
      <td><?php echo $resultats['email']?></td>
      <td><?php echo $resultats['login']?></td>
    </tr>
  </tbody>
   <?php } ?>
</table>