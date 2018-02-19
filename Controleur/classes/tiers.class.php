<?php

class Tiers
{
    protected $codeTiers, $nom, $prenom, $dateNaissance, $telephone, $codeLieu;
    
    public function __construct(){
        
        $this->codeTiers = "";
        $this->nom = "";
        $this->prenom = "";
        $this->dateNaissance = "";
        $this->telephone = "";
        $this->codeLieu = 0;
        
    }
    
    public function renseigner($tab){
        
        $this->nom = $tab['nom'];
        $this->prenom = $tab['prenom'];
        $this->dateNaissance = $tab['date_naissance'];
        $this->telephone = $tab['telephone'];
        $this->codeLieu = $tab['id_lieu'];
        
    }
    
    //Methode qui permet de serialiser l'objet -> tableau
    public function serialiser(){
        
        $tab = array();
        
        $tab['id_lieu'] = $this->codeLieu;
        $tab['nom'] = $this->nom ;
        $tab['prenom'] = $this->prenom;
        $tab['date_naissance'] = $this->dateNaissance;
        $tab['telephone'] = $this->telephone;
        
        return($tab);
    }
    
    /* GETTERS*/
    public function getCodeTiers(){
        return $this->codeTiers;
    }

    public function getNom(){
        
        return $this->nom;
        
    }
    
    public function getPrenom(){
        
        return $this->prenom;
        
    }

    public function getDateNaissance(){
        
        return $this->dateNaissance;
        
    }
    
    public function getTelephone(){
        
        return $this->telephone;
        
    }
    
    public function getCodeLieu(){
        
        return $this->codeLieu;
        
    }
    
    
    /* SETTERS */
    public function setCodeTiers($codeTiers){
        $this->codeTiers = $codeTiers;
    }

    public function setNom($nom){
        
        $this->nom = $nom;
        
    }
    
    public function setPrenom($prenom){
        
        $this->prenom = $prenom;
        
    }

    public function setDateNaissance($dateNaissance){
        
        $this->DateNaissance = $dateNaissance;
        
    }
    
    public function setTelephone($telephone){
        
        $this->telephone = $telephone;
        
    }
    
    public function setCodeLieu($codeLieu){
        
        $this->codeLieu = $codeLieu;
        
    }
 
}


?>