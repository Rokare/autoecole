<?php

class Etudiant extends Candidat{

    private $nivEtudiant, $reduc;

    public function __construct(){

        parent::__construct();
        $this->nivEtudiant = 0;
        $this->reduc = 0.0;
    }

    /*GETTERS*/
    public function getNivEtudiant(){
        return $this->nivEtudiant;
    }

    public function getReduc(){
        return $this->reduc;
    }

    /*SETTERS*/
    public function setNivEtudiant($nivEtudiant){
        $this->nivEtudiant = $nivEtudiant;
    }

    public function setReduc( $reduc){
        $this->reduc = $reduc;
    }

}


?>