<?php

class Salarie extends Candidat{

    private $nomEntreprise;

    public function __construct(){

        parent::__construct();
        $this->nomEntreprise = "";
    }

    /*GETTERS*/
    public function getNomEntreprise(){
        return $this->nomEntreprise;
    }

    /*SETTERS*/
    public function setNomEntreprise(){
        $this->nomEntreprise;
    }
}


?>