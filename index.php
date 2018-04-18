<!DOCTYPE html>

<?php
    include "controleur/controleur.php";
    include "controleur/classes/tiers.class.php";
?>

<html lang="fr">
   <head>


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <link rel="Stylesheet" href="Vue/css/bootstrap.css">
    <link rel="Stylesheet" href="ppeauto.css">
    <link rel="Stylesheet" href="Vue/style/style.css">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>

   </head>

    <body>
        <?php
                $page = (isset($_GET['page']))?$_GET['page'] : 0;
                $unControleur = new Controleur("localhost","","root","","tiers");
                include "Vue/vueBarreNavigation.php";

                switch($page)
                {
                    case 1:
                        include "Vue/vueInscription.php";
                        if(isset($_POST['inscription'])){
                            //INSERTION D'UN NOUVEAU TIERS
                            $unTiers = new Tiers();
                            $unTiers->renseigner($_POST);

                            $unControleur->insert($unTiers);
                            echo "<br> Insertion réussie <br>";
                        }
                    break;
                    case 2:
                    break;
                }
            ?>
    </body>

</html>
