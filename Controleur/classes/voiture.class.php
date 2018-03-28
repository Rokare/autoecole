<?php

class Voiture extends Vehicule
{
    protected $Conso, $NbPlace;
    public function __construct()
    {
        parent::__construct();
        $this->Conso = "";
        $this->NbPlace = "";
    }

    public function getConso()
    {
        return $this->Conso;
    }

    public function getNbPlace()
    {
        return $this->NbPlace;
    }


    public function setConso($Conso)
    {
        $this->Conso = $Conso;
    }

    public function setNbPlace($NbPlace)
    {
        $this->NbPlace = $NbPlace;
    }

}










?>