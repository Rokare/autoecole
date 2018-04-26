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


















 ?>
