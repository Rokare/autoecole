<!DOCTYPE html>

<?php
    include "controleur/controleur.php";
    include "controleur/classes/tiers.class.php";

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
        $unControleur = new Controleur("localhost","adlauto","root","","tiers");
        session_start ();
        $statut = $_SESSION['statut'];

        switch($statut)
        {
            case "personnel":
                include "Vue/vueNavBarPersonnel.php";
                if(isset($_POST['submit']) && empty($_SESSION['s_login']) && empty($_SESSION['s_nom']) && empty($_SESSION['s_prenom']) && empty($_SESSION['s_login'])) {
                  $unControleur->setTable('candidat');
                $resultat = $unControleur->rechercher($_POST);
                extract($_POST);
                $_SESSION['s_login'] = $login;
                $_SESSION['s_email'] = $email;
                $_SESSION['s_nom'] = $nom;
                $_SESSION['s_prenom'] = $prenom;
                }
                else {
                    $unControleur->setTable('candidat');
                  $resultat = $unControleur->rechercher2($_SESSION['s_login'],$_SESSION['s_nom'],$_SESSION['s_prenom'],$_SESSION['s_email']);
                }


                if(empty($resultat))
                {
                  echo "aucun resultat";
                }
                else {
                  include "Vue/vueResultat.php";
                }
                    if(isset($_GET['suppr']))
                    {
                      $unControleur->setDelchamp('matricule');
                      $unControleur->setDelvaleur($_GET['suppr']);
                      $unControleur->delete();
                      echo '<head>
                        <META HTTP-EQUIV="Refresh" CONTENT="0; URL=indexTiers.php">
                            </head> ';
                }

                break;
            case "moniteur":
                include "Vue/vueNavBarPersonnel.php";
                break;
            case "candidat":
                include "Vue/vueNavBarCandidat.php";
                include "Vue/vueCandidat.php";


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
