<!DOCTYPE html>

<?php
    include "controleur/controleur.php";
    include "controleur/classes/candidat.class.php";
    include "controleur/classes/salarie.class.php";
    include "controleur/classes/etudiant.class.php";


?>

<html lang="fr">
   <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <link href=".\">
    <link href="Vue/bootstrap-4.0.0-beta.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="Vue/style/style.css">
    <link href="Vue/bootstrap-4.0.0-beta.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="Vue/carousel.css" rel="stylesheet">
    <link href="Vue/pricing.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
   </head>

    <body>
        <div class="scrollbar" id="style-1">
      <div class="force-overflow"></div>
    </div>

        <?php


                $page = (isset($_GET['page']))?$_GET['page'] : 0;
                $unControleur = new Controleur("localhost","adlauto","root","","candidat");

                  include "Vue/vueBarreNavigation.php";
                

                if(isset($_POST["submit"]))
                {
                  extract($_POST);
                  if($unControleur->connexion($login,sha1($mdp)) == true)
                  {

                    header("Location:indexTiers.php");


                  }
                  else
                  {
                  echo'
                  <script>
                  alert("mauvais identifiants");
                  </script>';

                  }
                }
                switch($page)
                {
                    case 0:
                        include "Vue/vue_accueil.php";
                        break;
                    case 1:
                        include "Vue/vueinscription.php";
                        if(isset($_POST['inscription'])){
                          if($_POST['mdp'] == $_POST['confirm_mdp'])
                          {

                                   //INSERTION D'UN NOUVEAU TIERS
                                     if($_POST['statut'] == "salarie")
                                     {
                                       $unTiers = new Salarie();
                                       $unControleur->setTable("salarie");
                                     }

                                     elseif ($_POST['statut'] == "etudiant") {
                                       $unTiers = new Etudiant();
                                       $unControleur->setTable("etudiant");
                                     }
                                     else {
                                       $unTiers = new Candidat();
                                     }

                                   $unTiers->renseigner($_POST);
                                   $test = matricule();
                                   do {
                                     $test = matricule();
                                   }while ($unControleur->verifmatricule($test) == true);

                                   $matricule = $test;
                                   $matricule = matricule();

                                   try{
                                      $unControleur->insert($unTiers,$matricule);
                                   }
                                   catch(PDOException $exception)
                                   {
                                      echo "Le login ou l'email entré est déjà pris par un utilisateur";
                                   }

                                   if(empty($exception))
                                   {
                                     echo "<br> Insertion réussie <br>";
                                     echo "Redirection... <br>";
                                     echo '<head>
                                       <META HTTP-EQUIV="Refresh" CONTENT="1.5; URL=index.php?p=0">
                                           </head> ';
                                   }
                                 }
                           else {
                             echo 'Veuillez entrer le même mot de passe svp';
                           }

                         }
                    break;

                    case 2:
                        include "Vue/tarif.php";
                    break;

                    case 3:
                          include "Vue/vueCandidat.php";
                        break;
                    case 4 :
                    echo "<br> Pour utiliser le planning vous devez être connecter <br>";
                    echo "Redirection... <br>";
                    echo '<head>
                      <META HTTP-EQUIV="Refresh" CONTENT="1.5; URL=index.php?p=0">
                          </head> ';
                        break;



                }
            ?>
    </body>

</html>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"><\/script>')</script>
    <script src=" https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
    <script src="bootstrap-4.0.0-beta.2/dist/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/holderjs@2.9.4/holder.min.js"></script>
