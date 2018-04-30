<!DOCTYPE html>

<?php
    include "controleur/controleur.php";
    include "controleur/function.php";
    include "controleur/classes/candidat.class.php";
?>

<html lang="fr">
   <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">



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
                  if($unControleur->connexion($login,$mdp) == true)
                  {
                    $_SESSION['statut'] = $unControleur->verifstatut($login, $mdp);

                    header("Location:indexTiers.php");

                  }
                  else {
                    echo "mauvais identifiants";
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
                           //INSERTION D'UN NOUVEAU TIERS

                           $unCandidat = new Candidat();
                           $unCandidat->renseigner($_POST);
                           $test = matricule();
                           do {
                             $test = matricule();
                           }while ($unControleur->verifmatricule($test) == true);
                            $matricule = $test;
                           $matricule = matricule();
                           $unControleur->insert($unCandidat,$matricule);
                           echo "<br> Insertion réussie <br>";

                       }
                    break;
                    case 2:
                        include "Vue/tarif.php";
                    break;
                    case 3:
                          include "Vue/vueCandidat.php";
                        break;
                    case 4:
                        header ("Location:Vue/test_calendar/index.php");
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
