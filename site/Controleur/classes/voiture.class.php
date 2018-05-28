<?php

class Voiture extends Vehicule
{
    private $conso, $nbPlace;
    public function __construct()
    {
        parent::__construct();
        $this->conso = "";
        $this->nbPlace = "";
    }

    public function getConso()
    {
        return $this->conso;
    }

    public function getNbPlace()
    {
        return $this->nbPlace;
    }


    public function setConso($conso)
    {
        $this->conso = $conso;
    }

    public function setNbPlace($nbPlace)
    {
        $this->nbPlace = $nbPlace;
    }

}










?>
