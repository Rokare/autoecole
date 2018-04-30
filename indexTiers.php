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
                break;
            case "moniteur":
                include "Vue/vueNavBarPersonnel.php";
                break;
            case "candidat":
                include "Vue/vueNavBarCandidat.php";
                include "Vue/vueCandidat.php";
                if(isset ($_POST['submit'])) {
                    $resultat = $unControleur->rechercher($_POST);
                include "Vue/vueResultat.php";
                }
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
