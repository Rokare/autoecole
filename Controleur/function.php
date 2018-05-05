<?php

function matricule()
{

    $complexite = 3;
    $complexite2= 1;
    $mdp="";
    $chaine ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    for($i = 0; $i< $complexite; $i++)
    {
      $mdp .= $chaine[rand(0,25)];
    }
    for($i = 0; $i< $complexite; $i++)
    {
      $mdp .= $chaine[rand(26,51)];
    }
    for($i = 0; $i< $complexite2; $i++)
    {
      $mdp .= $chaine[rand(52,61)];
    }
    $mdp= str_shuffle($mdp);//permet de mélanger les caractères,meetre dans le désordre
    return $mdp;

}



function saveRecherche($login, $nom, $prenom, $email)
{
    $_SESSION['s_login'] = $login;
    $_SESSION['s_nom'] = $nom;
    $_SESSION['s_prenom'] = $prenom;

}

function Page($sp,$nbPage)
{
  if($sp>0 && $sp<=$nbPage)
   {
       return $cPage = $sp;
   }
   else
   {
       return $cPage = 1;
   }
}




 ?>
