<?php


class Lieu
{
    protected $idLieu, $cp, $ville, $adresse;

    public function __construct()
    {
        $this->idLieu = 0;
        $this->cp = "";
        $this->ville ="";
        $this->adresse = "";
    }

    public function getidLieu()
    {
        return $this->idLieu;
    }

    public function getCp()
    {
        return $this->cp;
    }
    public function getAnnee()
    {
        return $this->annee;
    }
    public function getVille()
    {
        return $this->ville;
    }

    public function setIdMois($idLieu)
    {
        $this->idLieu = $idLieu;
    }

    public function setAdresse($adresse)
    {
        $this->adresse = $adresse;
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