<?php

class vehicule 

    {
    protected $idVehicule, $NumImmatri, $NomMod, $AnneeMod, $DateAchat, $NbKiloIni, $Etat;
    public function __construct()
    {
        $this->idVehicule = 0;
        $this->NumImmatri = "";
        $this->NomMod = "";
        $this->AnneeMod = "";
        $this->DateAchat = "";
        $this->NbKiloIni = 0;
        $this->Etat = "";
    }




    public function renseigner($tab){
            
        $this->NumImmatri = $tab['num_immatri'];
        $this->NomMod = $tab['nom_mod'];
        $this->AnneeMod = $tab['annne_mod'];
        $this->DateAchat = $tab['date_achat'];
        $this->NbKiloIni = $tab['nb_kilo_ini'];
        $this->Etat = $tab['etat'];
        
    }

    //Methode qui permet de serialiser l'objet -> tableau
    public function serialiser(){
        
        $tab = array();
        $tab['num_immatri'] = $this->NumImmatri;
        $tab['nom_mod'] = $this->NomMod ;
        $tab['annne_mod'] =  $this->AnneeMod ;
        $tab['date_achat'] = $this->DateAchat;
        $tab['nb_kilo_ini'] = $this->NbKiloIni;
        $tab['etat'] = $this->Etat;
        return($tab);
    }

    
    /* GETTERS*/
    public function getIdVehicule(){
        return $this->idVehicule;
    }

    public function getNumImmatri(){
        
        return $this->NumImmatri;
        
    }
    
    public function getNomMod(){
        
        return $this->NomMod;
        
    }

    public function getAnneeMod(){
        
        return $this->AnneeMod;
        
    }
    
    public function getDateAchat(){
        
        return $this->DateAchat;
        
    }
    
    public function getNbKiloIni(){
        
        return $this->NbKiloIni;
        
    }

    public function getEtat(){
        return $this->Etat;
    }
    
    
    
    /* SETTERS */
    public function setIdVehicule($idVehicule){
        $this->idVehicule = $idVehicule;
    }

    public function setNumImmatri($NumImmatri){
        
        $this->NumImmatri = $NumImmatri;
        
    }
    
    public function setNomMod($NomMod){
        
        $this->NomMod = $NomMod;
        
    }

    public function setAnneeMod($AnneeMod){
        
        $this->AnneeMod = $AnneeMod;
        
    }
    
    public function setDateAchat($DateAchat){
        
        $this->DateAchat = $DateAchat;
        
    }
    
    public function setNbKiloIni($NbKiloIni){
        
        $this->NbKiloIni = $NbKiloIni;
        
    }

    public function setEtat($Etat)
    {
        $this->Etat = $Etat;
    }

}


?>