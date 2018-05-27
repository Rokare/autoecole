<?php

class Planning
{

    private $vehicule, $moniteur, $lecon, $candidat;

    public function __construct(){

        $this->vehicule = new Vehicule;
        $this->moniteur = new Moniteur;
        $this->lecon = new Lecon;
        $this->candidat = new Candidat;

    }

    public function getVehicule()
    {
      return $this->vehicule;
    }

    public function setVehicule($vehicule)
    {
      $this->vehicule = $vehicule;
    }

    public function getMoniteur()
    {
      return $this->moniteur;
    }

    public function setMoniteur($moniteur)
    {
      $this->moniteur = $moniteur;
    }

    public function getLecon()
    {
      return $this->lecon;
    }


    public function setLecon($lecon)
    {
      $this->lecon = $lecon;
    }


    public function getCandidat()
    {
      return $this->candidat;
    }


    public function setCandidat($candidat)
    {
      $this->candidat = $candidat;
    }

}

?>
