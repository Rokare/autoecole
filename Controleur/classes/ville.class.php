<?php


class Ville
{
    private $idVille, $cp, $ville;

    public function __construct()
    {
        $this->idVille = 0;
        $this->cp = "";
        $this->ville ="";
    }


/* GETTERS */
    public function getIdVille()
    {
        return $this->idVille;
    }

    public function getCp()
    {
        return $this->cp;
    }

    public function getVille()
    {
        return $this->ville;
    }


/* SETTERS */
    public function setIdVille($idVille)
    {
        $this->idVille = $idVille;
    }

    public function setCp($cp)
    {
        $this->cp = $cp;
    }
    public function setVille($ville)
    {
        $this->ville = $ville;
    }


}





?>
