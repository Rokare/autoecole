<?php

class Salarie extends Candidat{

    private $nomEntreprise;

    public function __construct(){

        parent::__construct();
        $this->nomEntreprise = "";
    }

    public function renseigner($tab){
      parent::renseigner($tab);
      $this->nomEntreprise = "a completer";
    }



    public function serialiser(){
      $tab = parent::serialiser();
      $tab['nom_entrep'] = $this->nomEntreprise;
      return $tab;
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
