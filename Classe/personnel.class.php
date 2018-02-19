<?php


class Personnel extends Tiers{
    protected $date_embauche, $date_fin;
    public function __construct()
    {
        parent::__construct();
 
        $this->date_embauche = "";
        $this->date_fin = "";
       
    }

 
    /* GETTERS */
    public function getDateEmbauche(){
        
        return $this->date_embauche;
        
    }
    public function getDateFin(){
        
        return $this->date_fin;
        
    }
 
    
    /* SETTERS */
  
    public function setDateEmbauche($date_embauche){
        
        $this->date_embauche = $date_embauche;
        
    }
    public function setDateFin($date_fin){
        
        $this->date_fin = $date_fin;
        
    }



}




?>