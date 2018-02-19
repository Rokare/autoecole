<?php


class Mois 
{
    protected $idMois, $Annee;

    public function __construct()
    {
        $this->idMois = 0;
        $this->Annee = "";
    }

    public function getidMois()
    {
        return $this->idMois;
    }

    public function getAnnee()
    {
        return $this->Annee;
    }

    public function setIdMois($idMois)
    {
        $this->idMois = $idMois;
    }

    public function setAnnee($Annee)
    {
        $this->Anne = $Annee;
    }


}





?>