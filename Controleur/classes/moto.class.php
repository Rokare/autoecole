<?php

class Moto extends Vehicule
{
    private $cylindre, $puissance;
    public function __construct()
    {
        parent::__construct();
        $this->cylindre = "";
        $this->puissance = "";
    }

    public function getCylindre()
    {
        return $this->cylindre;
    }

    public function getPuissance()
    {
        return $this->getPuissance;
    }


    public function setConso($cylindre)
    {
        $this->cylindre = $cylindre;
    }

    public function setPuisssance($puissance)
    {
        $this->puissance = $puissance;
    }

}










?>
