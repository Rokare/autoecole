<?php


class Moniteur extends Tiers{
    private $id, $date_embauche, $date_fin, $nom, $prenom, $date_naissance, $telephone;
    public function __construct()
    {
        $this->id=0;
        $this->date_embauche = "";
        $this->date_fin = "";
        $this->date_naissance ="";
        $this->telephone = "";
        $this->prenom = "";
        $this->nom = "";

    }


    public function getId()
    {
        return $this->id;
    }

    public function getNom(){
        
        return $this->nom;
        
    }
    
    public function getPrenom(){
        
        return $this->prenom;
        
    }

    public function getDateNaissance(){
        
        return $this->date_naissance;
        
    }
    
    public function getTelephone(){
        
        return $this->telephone;
        
    }
    
    public function getDateEmbauche(){
        
        return $this->date_embauche;
        
    }
    public function getDateFin(){
        
        return $this->date_fin;
        
    }
 
    
    
    /* SETTERS */
    public function setNom($nom){
        
        $this->nom = $nom;
        
    }
    
    public function setPrenom($prenom){
        
        $this->prenom = $prenom;
        
    }

    public function setDateNaissance($date_naissance){
        
        $this->date_naissance = $date_naissance;
        
    }
    
    public function setTelephone($telephone){
        
        $this->telephone = $telephone;
        
    }
    
    public function setDateEmbauche($date_embauche){
        
        $this->date_embauche = $date_embauche;
        
    }
    public function setDateFin($date_fin){
        
        $this->date_fin = $date_fin;
        
    }

    public function setId($id)
    {
        $this->id = $id;
    }







}










?>