<?php


class Lecon
{

    public $idLecon, $intitule, $duree, $dateHd;

    public function __construct()
    {
        $this->idLecon = 0;
        $this->intitule = "";
        $this->duree = "";
        $this->dateHd = "";
    }

    public function getIdLecon()
    {
        return $this->idLecon;
    }

    public function getIntitule()
    {
        return $this->intitule;
    }

    public function getDuree()
    {
        return $this->duree;
    }

    public function getDateHD(){
        return $this->dateHd;
    }


    public function setIdLecon($idLecon)
    {
        $this->idLecon = $idLecon;
    }
    public function setIntitule($intitule)
    {
        $this->intitule = $intitule;
    }
    public function setDuree($duree)
    {
        $this->duree = $duree;
    }
    public function setDateHd($dateHd){
        $this->dateHd = $dateHd;
    }
}

?>
