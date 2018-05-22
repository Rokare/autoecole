<?php
    include ("Modele/modele.php");
    include "function.php";

class Controleur
{
    private $unModele;

    public function __construct($serveur, $bdd, $user, $mdp, $table){

        $this->unModele = new Modele($serveur, $bdd, $user, $mdp);
        $this->unModele->setTable($table);

    }

    public function selectAll(){
        if($this->unModele->getPdo() != null){
            return $this->unModele->selectAll();
        }
    }

    public function selectAlternative($option){
        if($this->unModele->getPdo() != null){
            return $this->unModele->selectAlternative($option);
        }
    }

    public function pagination($login,$nom, $prenom, $email,$perPage)
    {
      if($this->unModele->getPdo() != null){
          return $this->unModele->pagination($login,$nom, $prenom, $email, $perPage);
      }
    }


    public function connexion($login, $mdp){
            return $this->unModele->connexion($login,$mdp);
    }

    public function verifstatut($login, $mdp){
            return $this->unModele->verifstatut($login,$mdp);
    }

    public function setTable($table){
        $this->unModele->setTable($table);
    }


    public function insert($unTiers,$matricule){
        $this->unModele->insert($unTiers->serialiser(), $matricule);
    }

    public function rechercher($login,$nom, $prenom, $email,$cPage, $perPage){
           if($this->unModele->getPdo() != null){
               return $this->unModele->rechercher($login,$nom, $prenom, $email,$cPage, $perPage);
           }
        }

    public function delete(){
        $this->unModele->delete();
    }

    public function setChamp($champ)
    {
      $this->unModele->setChamp($champ);
    }
    public function setValeur($valeur)
    {
      $this->unModele->setValeur($valeur);
    }

    public function updateCandidat($tab, $matricule){
      if($this->unModele->getPdo() != null){
        return $this->unModele->updateCandidat($tab, $matricule);
      }
    }


}



?>
