<?php

class Moto extends Vehicule
{
    protected $Cylindre, $Puissance;
    public function __construct()
    {
        parent::__construct();
        $this->Cylindre = "";
        $this->Puissance = "";
    }

    public function getCylindre()
    {
        return $this->Cylindre;
    }

    public function getPuissance()
    {
        return $this->getPuissance;
    }


    public function setConso($Cylindre)
    {
        $this->Cylindre = $Cylindre;
    }

    public function setPuisssance($Puissance)
    {
        $this->Puissance = $Puissance;
    }

}










?>