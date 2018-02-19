<?php

class Candidat extends Tiers{

    protected $dateInscription, $modeFacturation;

    public function __construct(){
        
        parent::__construct();
        $this->dateInscription = "";
        $this->modeFacturation = "";

    }


    /* GETTERS */
    public function getDateInscription(){
        return $this->dateInscription;
    }

    public function getModeFacturation(){
        return $this->modeFacturation;
    }


    /*SETTERS*/
    public function setDateInscription($dateInscription){
        $this->dateInscription = $dateInscription;
    }

    public function setModeFacturation($modeFacturation){
        $this->modeFacturation = $modeFacturation;
    }

}


?>