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
    
    public function setTable($table){
        $this->unModele->setTable($table);
    }
    
    public function insert($unTiers){
        $this->unModele->insert($unTiers->serialiser());
    }
    
}


    
?>