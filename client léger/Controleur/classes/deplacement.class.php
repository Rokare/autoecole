<?php

class Deplacement
{
    private $vehicule, $mois, $Nbkilometre;

    public function _construct()
    {
        $this->vehicule = new Vehicule;
        $this->mois = new Mois;
        $this->nbKilometre = "";
    }


    public function getVehicule()
    {
        return $this->vehicule;
    }

    public function getMois()
    {
        return $this->mois;
    }

    public function getNbKilometre()
    {
        return $this->nbKilometre;
    }


    public function setVehicule($vehicule)
    {
        $this->vehicule = $vehicule;
    }

    public function setMois($mois)
    {
        $this->mois = $mois;
    }

    public function setNbKilometre($nbkilometre)
    {
        $this->nbKilometre = $nbkilometre;
    }

}



















?>
