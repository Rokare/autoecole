<?php
    include ("Modele/modele.php");


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

    public function connexion($login, $mdp){
            return $this->unModele->connexion($login,$mdp);
    }

    public function verifstatut($login, $mdp){
            return $this->unModele->verifstatut($login,$mdp);
    }

    public function setTable($table){
        $this->unModele->setTable($table);
    }

    public function verifmatricule($matricule){
        $this->unModele->verifmatricule($matricule);
    }

    public function insert($unTiers,$matricule){
        $this->unModele->insert($unTiers->serialiser(), $matricule);
    }




    public function delete(){
       return  $this->unModele->delete();
    }




}



?>
