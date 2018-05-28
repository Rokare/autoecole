<?php

class Rouler
{
    protected $idVehicule, $idMois, $Nbkilometre;

    public function _construct()
    {
        $this->vehicule = new Vehicule;
        $this->mois = new Mois;
        $this->nbKilometre = "";
    }


    public function getIdVehicule()
    {
        return $this->vehicule->getIdVehicule;
    }

    public function getIdMois()
    {
        return $this->mois->getIdMois;
    }

    public function getNbKilimetre()
    {
        return $this->nbKilometre;
    }


    public function setIdVehicule($idVehicule)
    {
        $this->vehicule->getIdVehicule = $idVehicule->getIdVehicule;
    }

    public function setIdMois($idMois)
    {
        $this->mois->getIdMois = $idMois->getIdMois;
    }

    public function setNbKilometre($Nbkilometre)
    {
        $this->nbKilometre = $Nbkilometre;
    }

}



















?>