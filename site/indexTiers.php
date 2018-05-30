<!DOCTYPE html>

<?php
    include "controleur/controleur.php";
    include "controleur/classes/tiers.class.php";



?>

<html lang="fr">
   <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">




    <link rel="stylesheet" href="Vue/style/style.css">
    <link href="Vue/bootstrap-4.0.0-beta.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="Vue/carousel.css" rel="stylesheet">


    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>

   </head>

    <body>
        <div class="scrollbar" id="style-1">
      <div class="force-overflow"></div>
    </div>

        <?php
        $page = (isset($_GET['p']))?$_GET['p'] : 0;
        $unControleur = new Controleur("localhost","adlauto","root","","tiers");
        session_start ();
        $niveau = $_SESSION['niveau'];


        if(isset($_GET['sp']))
        {
          $sp = $_GET['sp'];
        }
        else {
          $sp = 1;
        }
        switch($niveau)
        {
            case ($niveau <= 2) :
              switch($page)
              {

                case 0 :
                include "Vue/vueNavBarPersonnel.php";
                include("./Vue/VuePersonnel.php");

                $unControleur->setTable('candidat');
                $perPage = 4 ;
                if(isset($_POST['submit']))
                {
                  extract($_POST);
                  $nbPage = $unControleur->pagination($login,$nom,$prenom,$email, $perPage);
                  $cPage = Page($sp, $nbPage);
                  $resultat = $unControleur->rechercher($login,$nom,$prenom,$email,$cPage, $perPage);
                  saveRecherche($login,$nom,$prenom,$email);
                }
                elseif(isset($_SESSION['s_login']) && isset($_GET['sp'])){
                  $nbPage = $unControleur->pagination($_SESSION['s_login'],$_SESSION['s_nom'],$_SESSION['s_prenom'],$_SESSION['s_email'], $perPage);
                  $cPage = Page($sp, $nbPage);
                  $resultat = $unControleur->rechercher($_SESSION['s_login'],$_SESSION['s_nom'],$_SESSION['s_prenom'],$_SESSION['s_email'],$cPage, $perPage);
                }
                if(empty($resultat))
                {
                  echo "aucun resultat";
                }
                else {
                  include("Vue/vueResultat.php");
                }
                    if(isset($_SESSION['suppr']))
                    {
                      $unControleur->setChamp('matricule');
                      $unControleur->setValeur($_SESSION['suppr']);
                      $unControleur->delete();
                      unset($_SESSION['suppr']);
                      echo '<head>
                        <META HTTP-EQUIV="Refresh" CONTENT="0; URL=indexTiers.php?p='.$Page.'&sp='.$nbPage.'">
                            </head> ';
                    }
                  break;
                  case 1 :

                  include("./Vue/vueNavBarPersonnel.php");

                  $unControleur->setChamp('matricule');

                  $unControleur->setValeur($_SESSION['modif']);


                  $resultats = $unControleur->selectAlternative(2);
                  unset($_SESSION['modif']);
                  if(!empty($resultats))
                  {
                    include("Vue/vueModification.php");
                    if(isset($_POST['update']))
                    {
                      if($unControleur->updateCandidat($_POST, $_SESSION['modif']) == true)
                      {
                        echo "mise à jour reussie : redirection...";
                        echo '<head>
                          <META HTTP-EQUIV="Refresh" CONTENT="1; URL=indexTiers.php?p=0">
                              </head> ';

                      }
                    }
                  }
                  break;
                  }
                break;
            case 3 :
                include "Vue/vueNavBarPersonnel.php";
                header("Location:fullcalendar2.php?matricule=".$_SESSION['matricule']);
                break;
            case 4:
                include "Vue/vueNavBarCandidat.php";
                include "Vue/vueCandidat.php";

                header("Location:fullcalendar.php?matricule=".$_SESSION['matricule']);


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