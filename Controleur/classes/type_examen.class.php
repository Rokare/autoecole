<?php

class TypeExamen
{
    private $idType, $libelle;

    public function __construct()
    {
        $this->idType = 0;
        $this->libelle = "";
    }

    public function getIdType()
    {
        return $this->idType;
    }
    public function getLibelle()
    {
        return $this->libelle;
    }

    public function setIdType($idType)
    {
        $this->idType = $idType;
    }

    public function setLibelle($libelle)
    {
        $this->libelle = $libelle;
    }


}







?>
