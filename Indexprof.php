<?php
     include ("controleur/controleur.php");
     include ("controleur/eleve.class.php");
     
?>
 
 <html>
  <body>
      <center> <h1> Gestion de l'ecole IRIS</h1>  
      
      <h2> Menu de Gestion </h2>
      <a href="index.php?page=1">Liste des eleves</a><br/>
      <a href="index.php?page=2">Ajout Eleve</a><br/>
      <a href="index.php?page=3">Recherche Eleve</a><br/>
      <a href="index.php?page=4">Suppression Eleve</a><br/>
 
      <?php
      $page = (isset($_GET['page']))?$_GET['page'] : 0;
      //instanciation de la classe Controleur
        $unControleur =  new Controleur ("localhost", "iris", "root", "", "eleve");
      switch($page)
      {
          case 1: 
              
                $resultats = $unControleur->selectAll();
                include("vue/vue.php"); 
              
          break;
          case 2:
              include "Vue/vueinsert.php";
              
              if (isset($_POST["valider"]))
              {
                  //insertin d'un nouvel eleve
                  $unEleve = new Eleve ();
                  $unEleve->renseigner($_POST);
                  $unControleur->insert ($unEleve);
                  echo "<br> Insertion reussie<br/>";
              }
          break;
          case 3:
          break;    
          case 4:
          break;    
      }
      
      ?>
      </center>
      
      
      
      
  </body>  
    
    
    
    
    
    
    
    
    
    
    
</html>