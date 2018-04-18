<?php

class Planning
{

    private $lesVehicules, $lesMoniteurs, $lesLecons, $lesCandidats;
    
    public function __construct($lesVehicules, $lesMoniteurs, $lesLecons, $lesCandidats){
        
        $this->lesVehicules = $lesVehicules;
        $this->lesMoniteurs = $lesMoniteurs;
        $this->lesLecons = $lesLecons;
        $this->lesCandidats = $lesCandidats;
        
    }
    
    public function getLesVehicules(){
        return $this->lesVehicules;
    }
    
    public function setLesVehicules($lesVehicules){
        $this->lesVehicules = lesVehicules;
    }
    
    public function getLesMoniteurs(){
        return $this->lesMoniteurs;
    }
    
    public function setLesMoniteurs($lesMoniteurs){
        $this->lesMoniteurs = $lesMoniteurs;
    }
    
    public function getLesLecons(){
        return $this->lesLecons;
    }
    
    public function setLesLecons($lesLecons){
        $this->lesLecons = $lesLecons;
    }
    
    public function getLesCandidats(){
        return $this->lesCandidats;
    }
    
    public function setLesCanidats(){
        $this->lesCandidats = $lesCandidats;
    }

}

?>