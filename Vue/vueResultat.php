<div class="col-md-7">
  <br><br>
    <div class="col-md-3 col-md-pull-9">
 <table class="table table-sm table-dark">
  <thead>
    <tr>
      <th scope="col">Nom</th>
      <th scope="col">Prénom</th>
      <th scope="col">E-mail</th>
      <th scope="col">Login</th>
      <th scope="col">Adresse</th>
      <th scope="col">Ville</th>
      <th scope="col">Date d'inscription</th>
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
            <td>".$resultats['adresse']."</td>
            <td>".$resultats['id_ville']."</td>
            <td>".$resultats['date_i']."</td>
            <td><a href ='indexTiers.php?p=".$page."&suppr&sp=".$nbPage."'  type='button' class='btn btn-danger'>Supprimer</a></td>
            <td><a href ='indexTiers.php?p=1&mod=".$resultats['matricule']."' type='button' class='btn btn-info'>Modifier</a></td>


            </tr/>
            ";

            if(isset($_GET['suppr']))
            {
              $_SESSION['suppr'] = $resultats['matricule'];
            }
            if(isset($_GET['mod']))
            {
              $_SESSION['modif'] = $resultats['matricule'];

            }


  }
}
   ?>
</table>

</div>






<nav aria-label="...">
  <ul class="pagination justify-content-center">


      <?php
    for($i=1;$i<=$nbPage;$i++)
    {

        if($i==$cPage)
        {
         echo '<li class="page-item active">
          <a class="page-link" href="#">'.$i.'<span class="sr-only">(current)</span></a>
        ';
         }
        else{
        echo "<li class='page-item'><a class='page-link' href='indexTiers.php?p=$page&sp=$i'>$i</a></li>";

        }
    }

    ?>
    </li>

  </ul>
</nav>
</div>
</div>
